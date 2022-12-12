package org.com.dream.cloud.commons.api.base.service;


import org.com.dream.cloud.commons.api.base.entity.BaseEntity;
import org.com.dream.cloud.commons.api.base.mapper.MyBaseMapper;

public interface IBaseService < T extends BaseEntity> {

    MyBaseMapper getBaseMapper();

    T selectById(Long id);

    int save(T t);

    int update(T t);

    int deleteById(Long id);

}
