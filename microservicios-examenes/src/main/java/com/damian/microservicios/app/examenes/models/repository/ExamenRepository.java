package com.damian.microservicios.app.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.damian.microservicios.comun.examenes.models.entity.Examen;



public interface ExamenRepository extends JpaRepository<Examen, Long> {
@Query("select e from Examen e where e.nombre like %?1%")
public List<Examen>findByNombre(String term);
@Query("select e.id from Pregunta p join p.examen e where p.id in ?1 group by e.id")
public Iterable<Long> findExamenIdsConRespuestasByPreguntasIds(Iterable<Long> alumnoids);
}
