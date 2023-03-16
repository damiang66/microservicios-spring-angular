package com.damian.microservicios.app.examenes.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.damian.microservicios.comun.examenes.models.entity.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

}
