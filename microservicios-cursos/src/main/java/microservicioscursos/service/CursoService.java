package microservicioscursos.service;







import com.damian.microservicios.comun.alumno.Alumno;
import com.example.common.service.CommonService;

import microservicioscursos.models.entity.Curso;

public interface CursoService extends CommonService<Curso> {

	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
}
