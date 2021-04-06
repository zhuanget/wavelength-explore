package com.zhuanget.wavelengthexplore.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

/**
 * @author Zhuang_ET
 * @since 2021-02-24 17:03:53
 */
@Configuration
@Slf4j
public class ApplicationStartUp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            environment = event.getApplicationContext().getBean(Environment.class);
            String username = environment.getProperty("spring.datasource.username");
            log.info("username: {}", username);
        } catch (Exception e) {
            log.error("init data error! e: ", e);
        }
    }
}
