package com.udacity.vehicles.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("cars")
                .pathsToMatch("/cars/**")
                .build();
    }

    @Bean
    public OpenAPI carsOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Cars API")
                        .description("This API lets you to have a list of cars")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Github Repository")
                        .url("https://github.com/JADM998/udacity-carWebService"));
    }
}
