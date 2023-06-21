package com.dealsandcouponsfinder.CartPayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class CartPayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartPayServiceApplication.class, args);
	}
 //create a bean for rest template //create a method that returns instance of a rest template


}
