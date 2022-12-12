package org.com.dream.cloud.business.reg;

import org.apache.dubbo.config.annotation.DubboReference;
import org.com.dream.cloud.commons.api.base.service.IBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminConsumerAppTests {
    @DubboReference
    private IBaseService baseService;

    @Test
    public void test(){
        System.out.println( baseService.selectById(1L));
    }
}
