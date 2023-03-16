package microservicioscursos.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.damian.microservicios.comun.alumno.Alumno;
import com.damian.microservicios.comun.examenes.models.entity.Examen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.damian.alumnos.models.entity.Alumno;


@Entity
@Table(name="cursos")
public class Curso {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotEmpty
private String nombre;
@Column(name="fecha")
@Temporal( TemporalType.TIMESTAMP)
private Date fecha;
//@OneToMany(fetch = FetchType.LAZY)
@Transient
private List<Alumno> alumnos;
@ManyToMany(fetch = FetchType.LAZY)
private List<Examen> examenes;
@JsonIgnoreProperties(value= {"curso"},allowSetters = true)
@OneToMany(fetch = FetchType.LAZY,mappedBy = "curso",cascade = CascadeType.ALL)
private List<CursoAlumno> cursoAlumnos;
@PrePersist
public void asignarFecha() {
	this.fecha= new Date();
}
public Curso() {
	this.alumnos = new ArrayList<>();
	this.examenes = new ArrayList<>();
	this.cursoAlumnos= new ArrayList<>();
}
public Long getId() {
	return id;
}

public List<Alumno> getAlumnos() {
	return alumnos;
}
public void setAlumnos(List<Alumno> alumnos) {
	this.alumnos = alumnos;
}
public void addAlumno(Alumno alumno) {
	this.alumnos.add(alumno);
	
}
public void deleteAlumno(Alumno alumno) {
	this.alumnos.remove(alumno);
}
public void setId(Long id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public List<Examen> getExamenes() {
	return examenes;
}
public void setExamenes(List<Examen> examenes) {
	this.examenes = examenes;
}
public void addExamen(Examen examen) {
	this.examenes.add(examen);
}
public void removeExamen(Examen examen) {
	this.examenes.remove(examen);
}
public List<CursoAlumno> getCursoAlumnos() {
	return cursoAlumnos;
}
public void setCursoAlumnos(List<CursoAlumno> cursoAlumnos) {
	this.cursoAlumnos = cursoAlumnos;
}
public void addCursoAlumnos(CursoAlumno cursoAlumno) {
	this.cursoAlumnos.add(cursoAlumno);
}
public void removeCursoAlumnos(CursoAlumno cursoAlumno) {
	this.cursoAlumnos.remove(cursoAlumno);
}


}
