package com.damian.microservicios.app.examenes.service;


import java.util.List;

import com.damian.microservicios.comun.examenes.models.entity.Asignatura;
import com.damian.microservicios.comun.examenes.models.entity.Examen;
import com.example.common.service.CommonService;

public interface ExamenService extends CommonService<Examen>  {
	public List<Examen>findByNombre(String term);
	
	public List<Asignatura> findAllAsignaturas();
	public Iterable<Long> findExamenIdsConRespuestasByPreguntasIds(Iterable<Long> alumnoids);
}
