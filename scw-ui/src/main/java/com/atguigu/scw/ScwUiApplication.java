package com.atguigu.scw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class ScwUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScwUiApplication.class, args);
	}

}
