package com.damian.microservicios.comun.examenes.models.entity;
/*
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="examenes")
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@NotEmpty
	@Size(min = 4,max = 30)
	private String nombre;
	@Column(name="fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
	@OneToMany(mappedBy = "examen",fetch= FetchType.LAZY,cascade =CascadeType.ALL,orphanRemoval = true)
	private List<Pregunta> preguntas;
	@JsonIgnoreProperties(value= {"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Asignatura asignaturaPadre;
	@JsonIgnoreProperties(value= {"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Asignatura asignaturaHija;
	@Transient
	private boolean respondido;
	@PrePersist
	public void persistirFecha() {
		this.fecha= new Date();
	}
	public Examen() {
		this.preguntas= new ArrayList<>();
	}
	public Long getId() {
		return id;
	}
	
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas.clear();
		preguntas.forEach(p->{
			this.addPreguntas(p);
		});
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
	public void addPreguntas(Pregunta pregunta) {
		this.preguntas.add(pregunta);
		pregunta.setExamen(this);
}
	public void removePreguntas(Pregunta pregunta) {
		this.preguntas.remove(pregunta);
		pregunta.setExamen(null);
}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Examen)) {
			return false;
		}
		Examen a = (Examen) obj;
		
		return this.id !=null && this.id.equals(a.getId());
	}
	
	public Asignatura getAsignaturaPadre() {
		return asignaturaPadre;
	}
	public void setAsignaturaPadre(Asignatura asignaturaPadre) {
		this.asignaturaPadre = asignaturaPadre;
	}
	public Asignatura getAsignaturaHija() {
		return asignaturaHija;
	}
	public void setAsignaturaHija(Asignatura asignaturaHija) {
		this.asignaturaHija = asignaturaHija;
	}
	public boolean isRespondido() {
		return respondido;
	}
	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}
	
}
*/
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="examenes")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max=30)
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	private Date fecha;
	
	@JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
	@OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pregunta> preguntas;
	
	@JsonIgnoreProperties(value= {"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Asignatura asignaturaPadre;
	
	@JsonIgnoreProperties(value= {"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Asignatura asignaturaHija;
	
	@Transient
	private boolean respondido;

	public Examen() {
		this.preguntas = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
	
	public Long getId() {
		return id;
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

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas.clear();
		preguntas.forEach(this::addPregunta);
		
	}
	
	public void addPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
		pregunta.setExamen(this);
	}

	public void removePregunta(Pregunta pregunta) {
		this.preguntas.remove(pregunta);
		pregunta.setExamen(null);
	}

	public Asignatura getAsignaturaPadre() {
		return asignaturaPadre;
	}

	public void setAsignaturaPadre(Asignatura asignaturaPadre) {
		this.asignaturaPadre = asignaturaPadre;
	}

	public Asignatura getAsignaturaHija() {
		return asignaturaHija;
	}

	public void setAsignaturaHija(Asignatura asignaturaHija) {
		this.asignaturaHija = asignaturaHija;
	}

	public boolean isRespondido() {
		return respondido;
	}

	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Examen)) {
			return false;
		}

		Examen a = (Examen) obj;
		
		return this.id != null && this.id.equals(a.getId());
	}
	
	
}
