package com.example.springbootpractice2.configurations;

import com.example.springbootpractice2.handlers.AuditAwareHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Configuration for auditing
 *
 * @author Bahadir Tasli
 * @Date 2/27/2023
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditAwareHandler();
    }
}
