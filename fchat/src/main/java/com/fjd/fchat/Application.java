package com.fjd.fchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
public class Application {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("FChat").select()
                .apis(RequestHandlerSelectors.basePackage("com.fjd.fchat"))
                .paths(any()).build().apiInfo(new ApiInfo("FChat Services",
                        "A set of services to provide chat services data access", "1.0.0", null,
                        new Contact("FJD", "https://twitter.com/fanjingdan", null),null, null));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}