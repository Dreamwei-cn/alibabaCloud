package org.com.dream.cloud.business.oauth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Oauth2AppTests {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    public void testPasswordEncoder(){
       System.out.println(passwordEncoder.encode("secret"));

    }
}
