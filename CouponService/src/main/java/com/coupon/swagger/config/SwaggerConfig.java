package com.coupon.swagger.config;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
	    .select()
	    .apis(RequestHandlerSelectors.basePackage("com.coupon"))
	    .paths(PathSelectors.any())

	    .build();
	    }

}
