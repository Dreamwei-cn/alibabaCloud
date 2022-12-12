package org.com.dream.cloud.provider.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.com.dream.cloud.commons.api.base.service.impl.BaseServiceImpl;
import org.com.dream.cloud.provider.log.entity.LogInfo;
import org.com.dream.cloud.provider.log.service.ILogInfoService;
import org.com.dream.cloud.provider.mapper.LogInfoMapper;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "0.0.1")
public class LogInfoServiceImpl extends BaseServiceImpl<LogInfoMapper, LogInfo> implements ILogInfoService {
}
