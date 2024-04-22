package com.ruoyi.framework.web.service;

import com.ruoyi.common.utils.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/16 21:44:24
 * @Version: 1.0.0
 */
@SpringBootTest
class SysPasswordServiceTest {

    @Test
    public void testBCryptPasswordEncoder() {
        String password = SecurityUtils.encryptPassword("Yuning");
        System.out.println(password);
    }
}
