
package com.damian.microserviciosudemy.service;


import java.util.List;



import com.damian.microservicios.comun.alumno.Alumno;
//import com.damian.alumnos.models.entity.Alumno;
import com.example.common.service.CommonService;

public interface AlumnoService extends CommonService<Alumno>{
 public List<Alumno> findByNombreOrApellido(String term);
 public Iterable<Alumno> findAllById(Iterable<Long> ids);
 public void eliminarAlumnoDelCurso(Long id);
}
