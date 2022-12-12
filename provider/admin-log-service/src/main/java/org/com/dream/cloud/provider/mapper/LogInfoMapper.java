package org.com.dream.cloud.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.dream.cloud.commons.api.base.mapper.MyBaseMapper;
import org.com.dream.cloud.provider.log.entity.LogInfo;
import org.com.dream.cloud.provider.log.entity.LogInfoExample;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
public interface LogInfoMapper extends MyBaseMapper<LogInfo> {
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