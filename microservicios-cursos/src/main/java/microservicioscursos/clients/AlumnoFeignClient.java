package microservicioscursos.clients;



import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.damian.microservicios.comun.alumno.Alumno;

@FeignClient(name = "microservicio-usuarios")
public interface AlumnoFeignClient {

	@GetMapping("/alumnos-por-curso")
	public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
