package org.com.dream.cloud.code.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.dream.cloud.code.entity.LogInfo;
import org.com.dream.cloud.code.entity.LogInfoExample;

public interface LogInfoMapper {
    long countByExample(LogInfoExample example);

    int deleteByExample(LogInfoExample example);

    int deleteByPrimaryKey(Long logid);

    int insert(LogInfo record);

    int insertSelective(LogInfo record);

    List<LogInfo> selectByExample(LogInfoExample example);

    LogInfo selectByPrimaryKey(Long logid);

    int updateByExampleSelective(@Param("record") LogInfo record, @Param("example") LogInfoExample example);

    int updateByExample(@Param("record") LogInfo record, @Param("example") LogInfoExample example);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);
}