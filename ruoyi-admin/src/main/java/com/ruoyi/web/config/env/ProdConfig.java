package com.ruoyi.web.config.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/03/13 22:58:03
 * @Version: 1.0.0
 */

@Profile("prod")
@Configuration
@PropertySource(value = {"classpath:env/prod/application.properties", "classpath:env/prod/application-druid.properties"}, encoding = "utf-8")
public class ProdConfig {
}
