package com.damian.microservicios.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
@EntityScan({"com.damian.microservicios.app.respuestas",
	 "com.damian.microservicios.comun.alumno",
	 "com.damian.microservicios.comun.examenes.models.entity"})
	 */
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviciosRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRespuestasApplication.class, args);
	}

}
