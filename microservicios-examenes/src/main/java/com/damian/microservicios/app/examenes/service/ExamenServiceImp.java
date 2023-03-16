package com.damian.microservicios.app.examenes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damian.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.damian.microservicios.app.examenes.models.repository.ExamenRepository;
import com.damian.microservicios.comun.examenes.models.entity.Asignatura;
import com.damian.microservicios.comun.examenes.models.entity.Examen;
import com.example.common.service.CommonServiceImpl;
@Service
public class ExamenServiceImp extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService{
	@Autowired
	private AsignaturaRepository asignaturaR;
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		
		return this.repositorio.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		
		return (List<Asignatura>) asignaturaR.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenIdsConRespuestasByPreguntasIds(Iterable<Long> alumnoids) {
		
		return repositorio.findExamenIdsConRespuestasByPreguntasIds(alumnoids);
	}

}
