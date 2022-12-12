package org.com.dream.cloud.code.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.dream.cloud.code.entity.AuthRole;
import org.com.dream.cloud.code.entity.AuthRoleExample;

public interface AuthRoleMapper {
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