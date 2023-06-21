package com.dealsandcouponsfinder.CartPayService.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	//creating method for docket 
	@Bean
    public Docket productApi()
    {
	//return a docket instance
    return new Docket(DocumentationType.SWAGGER_2)  //enabling swagger2
    .select()                                       //get the builder object
    .apis(RequestHandlerSelectors.basePackage("com.cart"))
    .paths(PathSelectors.any())

    .build();
    }


}

