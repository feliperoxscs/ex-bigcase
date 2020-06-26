package com.mastertech.zuulnotafiscal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulNotafiscalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulNotafiscalApplication.class, args);
	}

}
