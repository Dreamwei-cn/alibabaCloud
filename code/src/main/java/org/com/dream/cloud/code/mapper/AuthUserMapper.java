package org.com.dream.cloud.code.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.dream.cloud.code.entity.AuthUser;
import org.com.dream.cloud.code.entity.AuthUserExample;

public interface AuthUserMapper {
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
}