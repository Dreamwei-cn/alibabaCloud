package org.com.dream.cloud.commons.api.base.service.impl;



import org.com.dream.cloud.commons.api.base.entity.BaseEntity;
import org.com.dream.cloud.commons.api.base.mapper.MyBaseMapper;
import org.com.dream.cloud.commons.api.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseServiceImpl <M extends MyBaseMapper<T1>, T1 extends BaseEntity> implements IBaseService< T1> {
    @Autowired
    private M baseMapper;

    @Override
    public M getBaseMapper() {
        return baseMapper;
    }

    @Override
    public T1 selectById(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(T1 t) {
        return baseMapper.insert(t);
    }

    @Override
    public int update(T1 t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int deleteById(Long id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

}
