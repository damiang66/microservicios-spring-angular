package com.damian.microserviciosudemy;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableEurekaClient
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EntityScan({"com.damian.microservicios.comun.alumno"})
public class MicroserviciosUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosUdemyApplication.class, args);
	}

}
