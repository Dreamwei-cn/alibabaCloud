package org.com.dream.cloud.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.dream.cloud.admin.api.entity.AuthRole;
import org.com.dream.cloud.admin.api.entity.AuthRoleExample;

import org.com.dream.cloud.commons.api.base.mapper.MyBaseMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
public interface AuthRoleMapper extends MyBaseMapper<AuthRole> {
    long countByExample(AuthRoleExample example);

    int deleteByExample(AuthRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    List<AuthRole> selectByExample(AuthRoleExample example);

    AuthRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    int updateByExample(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);
}