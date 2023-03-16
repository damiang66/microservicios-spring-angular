package com.damian.microservicios.app.respuestas.models.repository;
/*
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.damian.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {
	@Query("{'alumnoId':?0,'preguntaId': { $in:?1 }}")
	public Iterable<Respuesta>FindRespuestaByAlumnoByPreguntasIds(Long alumnoId,Iterable<Long>preguntaId);	
	@Query("{'alumnoId:?0}")
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId);
	/* esto es con Jpa Repository
@Query("select r from Respuesta r  join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2" )
public Iterable<Respuesta>FindRespuestaByAlumnoByExamen(Long alumnoId,Long examenId);
@Query("select e.id from Respuesta r  Join r.pregunta p join p.examen e where r.alumnoId=?1 group by e.id")
public Iterable<Long> findExamenIdsConRespuestasByIdAlumno(Long alumnoid);

	@Query("{'alumnoId:?0,'pregunta.examen.id:?1}")
	public Iterable<Respuesta>findRespuestabyAlumnoByExamen(Long alumnoId, Long examenId);
	@Query(value="{'alumnoId:?0'}",fields = "{'pregunta.examenid:1'}")
	public Iterable<Respuesta> findExamenesIdsConRespuestasbyAlumno(Long alumnoId);
}
*/
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.damian.microservicios.app.respuestas.models.entity.Respuesta;



public interface RespuestaRepository extends MongoRepository<Respuesta, String> {

	@Query("{'alumnoId': ?0, 'preguntaId': { $in: ?1} }")
	public Iterable<Respuesta> findRespuestaByAlumnoByPreguntaIds(Long alumnoId, Iterable<Long> preguntaIds);
	
	@Query("{'alumnoId': ?0}")
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId);
	
	//@Query("select r from Respuesta r join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
	//public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
	
	//@Query("select e.id from Respuesta r join r.pregunta p join p.examen e where r.alumnoId=?1 group by e.id")
	//public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
