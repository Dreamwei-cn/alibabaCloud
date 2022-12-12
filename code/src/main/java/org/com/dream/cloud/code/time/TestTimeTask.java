package org.com.dream.cloud.code.time;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@Slf4j
@Configuration
@EnableAsync
public class TestTimeTask {


//    @Scheduled(fixedDelay = 1000)
//    @Scheduled(fixedRate = 3000)
    @Async
    @Scheduled(cron ="*/5 * * * * ?")
    public void timeTaskOne()  {

        try {
            Thread.sleep(1000*10);
            System.out.println("任务时间：" + LocalDateTime.now().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
