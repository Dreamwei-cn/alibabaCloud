package org.com.dream.cloud.code.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class OrderService {


    private Map<String, Object> mutexCache = new ConcurrentHashMap<>();


    // tomcat 最多线程 200  超过 200个  前200有199在 等待锁， 第一个执行完 删除锁， 201 创建新锁
    public void runMethod(String order, Runnable runnable){

        Object mutexKey =  mutexCache.computeIfAbsent(order,k ->new Object());
        synchronized (mutexKey){
            try {
                runnable.run();
            }finally {
                mutexCache.remove(order);
            }


        }

    }

    private Map<String, ReentrantLock> lockCache = new ConcurrentHashMap<>();

    public void runMethond(String order, Runnable runnable){

        ReentrantLock mutexKey =  lockCache.computeIfAbsent(order,k ->new ReentrantLock());
        // 获取锁被删除了；
        mutexKey.lock();
        try {
            runnable.run();
        }finally {
            if (mutexKey.getQueueLength() == 0)
                lockCache.remove(order);
            mutexKey.unlock();
        }

    }

    public void runMethond2(String order, Runnable runnable){

        ReentrantLock mutexKey =  null;
        // 获取锁被删除了；
        ReentrantLock mutexInCache = null;
        do {
            if (mutexKey != null){
                mutexKey.unlock();
            }
            mutexKey =  lockCache.computeIfAbsent(order,k ->new ReentrantLock());
            mutexKey.lock();
            mutexInCache = lockCache.get(order);
        }while (mutexInCache == null || !mutexKey.equals(mutexInCache));

        try {
            runnable.run();
        }finally {
            if (mutexKey.getQueueLength() == 0)
                lockCache.remove(order);
            mutexKey.unlock();
        }

    }
}
