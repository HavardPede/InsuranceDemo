package com.integration.config;

import com.integration.endpoint.InsuranceService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/*
   ## Description
    The Jersey configuration to initialise the HTTP Endpoints.
 */

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(InsuranceService.class);
    }
}