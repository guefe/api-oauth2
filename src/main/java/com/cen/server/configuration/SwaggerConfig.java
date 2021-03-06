package com.cen.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        //Adding Header Authorization header
        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(new ParameterBuilder()
                .name("Authorization")
                .description("Bearer Token")
                .modelRef(new ModelRef("string"))
                .defaultValue("Bearer [replace with token]")
                .parameterType("header")
                .required(false)
                .build());

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.cen"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(aParameters);
    }
}
