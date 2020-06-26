package com.mastertech.reativonotafiscal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReativoNotaFiscalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReativoNotaFiscalApplication.class, args);
	}

}
