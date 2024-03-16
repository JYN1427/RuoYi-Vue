package com.ruoyi.web.config.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/03/13 22:57:56
 * @Version: 1.0.0
 */

@Profile("stage")
@Configuration
@PropertySource(value = {"classpath:env/stage/application.properties", "classpath:env/stage/application-druid.properties"}, encoding = "utf-8")
public class TestConfig {
}
