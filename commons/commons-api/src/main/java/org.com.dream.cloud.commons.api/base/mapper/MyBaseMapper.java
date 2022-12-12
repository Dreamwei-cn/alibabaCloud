package org.com.dream.cloud.commons.api.base.mapper;


public interface MyBaseMapper<T> {

    T selectByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int deleteByPrimaryKey(Long id);

}
