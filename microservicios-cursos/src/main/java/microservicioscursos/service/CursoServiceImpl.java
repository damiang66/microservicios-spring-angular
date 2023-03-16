package microservicioscursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damian.microservicios.comun.alumno.Alumno;
import com.example.common.service.CommonServiceImpl;

import microservicioscursos.clients.AlumnoFeignClient;
import microservicioscursos.clients.RespuestaFeingClient;
import microservicioscursos.models.entity.Curso;
import microservicioscursos.models.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {
	@Autowired
	private RespuestaFeingClient client;
	
	@Autowired
	private AlumnoFeignClient clientAlumno;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repositorio.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids) {
		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}

	@Override
	@Transactional
	public void eliminarCursoAlumnoPorId(Long id) {
		repositorio.eliminarCursoAlumnoPorId(id);
	}

}
