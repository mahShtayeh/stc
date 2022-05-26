package com.stc.leaves.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LeaveConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
