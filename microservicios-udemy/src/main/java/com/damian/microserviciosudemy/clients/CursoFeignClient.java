package com.damian.microserviciosudemy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="microservicio-cursos")
public interface CursoFeignClient {
@DeleteMapping("/eliminar-alumno/{id}")
public void eliminarAlumnoDelCurso(@PathVariable Long id);

}