package com.borict.candidatemanagement.configs;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI candidateManagementOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Candidate Management System API")
                        .description("REST API for managing candidates and their skills")
                        .version("1.0.0")
                );
    }
}
