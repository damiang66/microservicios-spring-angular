package microservicioscursos;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@EntityScan({"com.damian.microservicios.comun.examenes.models.entity",
	"microservicioscursos.models.entity","com.damian.microservicios.comun.alumno",
	"microservicioscursos.models.entity"})
@SpringBootApplication
public class MicroserviciosCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursosApplication.class, args);
	}

}
