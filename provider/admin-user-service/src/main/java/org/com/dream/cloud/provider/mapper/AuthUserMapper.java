package org.com.dream.cloud.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.admin.api.entity.AuthUserExample;

import org.com.dream.cloud.commons.api.base.mapper.MyBaseMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
public interface AuthUserMapper extends MyBaseMapper<AuthUser> {
    long countByExample(AuthUserExample example);

    int deleteByExample(AuthUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    List<AuthUser> selectByExample(AuthUserExample example);

    AuthUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    int updateByExample(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);

    AuthUser selectByName(String name);
}