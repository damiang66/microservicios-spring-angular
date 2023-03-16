package com.damian.microservicios.app.respuestas.clients;
/*
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.damian.microservicios.comun.examenes.models.entity.Examen;

@FeignClient(name="microservicio-examenes")
public interface ExamenClient {
	@GetMapping("/{id}")
	public Examen optenerExamenPorId(@PathVariable Long id);
	@GetMapping("/respondidos")
	public List<Long> obtenerExamenesidsPorPreguntasIdResponsidas(@RequestParam List<Long> preguntasIds);
}
*/
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.damian.microservicios.comun.examenes.models.entity.Examen;



@FeignClient(name = "microservicio-examenes")
public interface ExamenClient {

	@GetMapping("/{id}")
	public Examen obtenerExamenPorId(@PathVariable Long id);
	
	@GetMapping("/respondidos-por-preguntas")
	public List<Long> obtenerExamenesIdsPorPreguntasIdRespondidas(@RequestParam List<Long> preguntaIds);
}
