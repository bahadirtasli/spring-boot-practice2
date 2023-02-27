package com.example.springbootpractice2.handlers;

import com.example.springbootpractice2.utils.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Custom handler to implement AuditAWARE
 * @author Bahadir Tasli
 * @Date 2/27/2023
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() /*Set the value for CreatedBy & Lastmodified by*/ {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}
