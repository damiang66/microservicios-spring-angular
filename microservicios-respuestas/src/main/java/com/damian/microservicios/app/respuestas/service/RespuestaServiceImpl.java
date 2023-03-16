package com.damian.microservicios.app.respuestas.service;
/*
//import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//import com.damian.microservicios.app.respuestas.clients.ExamenClient;
import com.damian.microservicios.app.respuestas.models.entity.Respuesta;
import com.damian.microservicios.app.respuestas.models.repository.RespuestaRepository;
//import com.damian.microservicios.comun.examenes.models.entity.Examen;
//import com.damian.microservicios.comun.examenes.models.entity.Pregunta;

@Service
public class RespuestaServiceImpl implements RespuestaService {
	//@Autowired
	//private ExamenClient clienteExamen;
	@Autowired
	private RespuestaRepository repositorio;

	@Override
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {

		return repositorio.saveAll(respuestas);
	}

	@Override
	public Iterable<Respuesta> FindRespuestaByAlumnoByPreguntasIds(Long alumnoId, Long examenId) {
		/*Examen examen = clienteExamen.optenerExamenPorId(examenId);
		List<Pregunta> preguntas = examen.getPreguntas();
		List<Long> PreguntasIds = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas = (List<Respuesta>) repositorio.FindRespuestaByAlumnoByPreguntasIds(alumnoId,
				PreguntasIds);
		respuestas = respuestas.stream().map(r -> {
			preguntas.forEach(p -> {
				if (p.getId() == r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());
		
		List<Respuesta> respuestas = (List<Respuesta>) repositorio.findRespuestabyAlumnoByExamen(alumnoId,
				examenId);
		return respuestas;
	}

	@Override
	public Iterable<Long> findExamenIdsConRespuestasByIdAlumno(Long alumnoid) {
		/*
		List<Respuesta> respuestaAlumno = (List<Respuesta>) repositorio.findByAlumnoId(alumnoid);
		List<Long> examenIds = Collections.emptyList();
		if(respuestaAlumno.size()>0) {
		List<Long>preguntasIds = respuestaAlumno.stream().map(r-> r.getPreguntaId()).collect(Collectors.toList());
		examenIds= clienteExamen.obtenerExamenesidsPorPreguntasIdResponsidas(preguntasIds);
		}	
		
		List<Respuesta> respuestaAlumno = (List<Respuesta>) repositorio.findExamenesIdsConRespuestasbyAlumno(alumnoid);
		List<Long>examenIds=respuestaAlumno
				.stream()
				.map(r->r.getPregunta().getExamen().getId())
				.distinct().
				collect(Collectors.toList());
		return examenIds;
	}

	@Override
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
		
		return repositorio.findByAlumnoId(alumnoId);
	}

}
*/
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damian.microservicios.app.respuestas.clients.ExamenClient;
import com.damian.microservicios.app.respuestas.models.entity.Respuesta;
import com.damian.microservicios.app.respuestas.models.repository.RespuestaRepository;
import com.damian.microservicios.comun.examenes.models.entity.Examen;
import com.damian.microservicios.comun.examenes.models.entity.Pregunta;


@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private RespuestaRepository repository;
	
	@Autowired
	private ExamenClient  examenClient;
	
	@Override
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repository.saveAll(respuestas);
	}

	@Override
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		Examen examen = examenClient.obtenerExamenPorId(examenId);
		List<Pregunta> preguntas = examen.getPreguntas();
		List<Long> preguntaIds = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlumnoByPreguntaIds(alumnoId, preguntaIds);
		respuestas = respuestas.stream().map(r ->{
			preguntas.forEach(p ->{
				if(p.getId() == r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());
				
		return respuestas;
	}

	@Override
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
		List<Respuesta> respuestasAlumno = (List<Respuesta>) repository.findByAlumnoId(alumnoId);
		List<Long> examenIds = Collections.emptyList();
		
		if(respuestasAlumno.size() > 0) {
		  List<Long> preguntaIds = respuestasAlumno.stream().map(r -> r.getPreguntaId()).collect(Collectors.toList());
		  examenIds = examenClient.obtenerExamenesIdsPorPreguntasIdRespondidas(preguntaIds);
		}
		
		return examenIds;
	}

	@Override
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
		return repository.findByAlumnoId(alumnoId);
	}

}
