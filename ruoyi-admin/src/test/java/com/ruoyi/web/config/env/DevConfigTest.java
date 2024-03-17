package com.ruoyi.web.config.env;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/12 21:51:37
 * @Version: 1.0.0
 */
@SpringBootTest
public class DevConfigTest {

    @Value("${ruoyi.name}")
    private String name;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        System.out.println(name);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
