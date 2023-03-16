
package com.damian.microserviciosudemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damian.microservicios.comun.alumno.Alumno;
import com.damian.microserviciosudemy.clients.CursoFeignClient;
//import com.damian.alumnos.models.entity.Alumno;
import com.damian.microserviciosudemy.model.repositoy.AlumnoRepository;
import com.example.common.service.CommonServiceImpl;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService{
	@Autowired(required = true)
	private CursoFeignClient clientCurso;
	@Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
      return repositorio.findAllByOrderByIdAsc();
    }
	
	@Override
	public Page<Alumno> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repositorio.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
	
		return this.repositorio.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		
		return this.repositorio.findAllById(ids);
	}

	@Override
	public void eliminarAlumnoDelCurso(Long id) {
		this.clientCurso.eliminarAlumnoDelCurso(id);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		this.eliminarAlumnoDelCurso(id);
	}
	

    
    
}
