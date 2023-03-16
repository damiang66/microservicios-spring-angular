
package com.damian.microserviciosudemy.controller;


import com.damian.microservicios.comun.alumno.Alumno;
//import com.damian.alumnos.models.entity.Alumno;
import com.damian.microserviciosudemy.service.AlumnoService;
import com.example.common.controller.CommonController;



import java.io.IOException;
import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {
	@GetMapping("/alumnos-por-curso")
	public ResponseEntity<?> obtenerAlumnosPorCurso(@RequestParam List<Long> ids){
		
		return ResponseEntity.ok(this.service.findAllById(ids));
	}
  @GetMapping("/uploads/img/{id}")
  public ResponseEntity<?> verFoto(@PathVariable Long id){
	  Optional<Alumno> o = this.service.findById(id);
	  if(o.isEmpty() || o.get().getFoto()==null) {
		  return ResponseEntity.notFound().build();
	  }
	  Resource imagen = new ByteArrayResource(o.get().getFoto());
	  return ResponseEntity.ok()
			  .contentType(MediaType.IMAGE_JPEG)
			  .body(imagen);
  }
   
  @PutMapping("/{id}")
  public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno,BindingResult result,@PathVariable Long id){
       Optional<Alumno> respuesta = this.service.findById(id);
       if(result.hasErrors()) {
 		  return this.validar(result);
 	  }
      if (respuesta.isPresent()){
          Alumno db = respuesta.get();
          db.setNombre(alumno.getNombre());
          db.setEmail(alumno.getEmail());
          db.setApellido(alumno.getApellido());
          this.service.save(db);
          return ResponseEntity.status(HttpStatus.CREATED).body(db);
  }
      
      return ResponseEntity.notFound().build();
  }
 @GetMapping("/filtrar/{termino}")
 public ResponseEntity<?> filtrar(@PathVariable String termino){
	 return ResponseEntity.ok(this.service.findByNombreOrApellido(termino));
 }
@PostMapping("/crear-con-foto")
public ResponseEntity<?> crearConFoto(@Valid Alumno alumno, BindingResult result, 
		@RequestParam MultipartFile archivo) throws IOException {
	if (!archivo.isEmpty()) {
		alumno.setFoto(archivo.getBytes());
	}
	return super.crear(alumno, result);
}   
@PutMapping("/editar-con-foto/{id}")
public ResponseEntity<?> editarConFoto(@Valid  Alumno alumno,BindingResult result,
		@PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
     Optional<Alumno> respuesta = this.service.findById(id);
     if(result.hasErrors()) {
		  return this.validar(result);
	  }
    if (respuesta.isPresent()){
        Alumno db = respuesta.get();
        db.setNombre(alumno.getNombre());
        db.setEmail(alumno.getEmail());
        db.setApellido(alumno.getApellido());
        if (!archivo.isEmpty()) {
    		db.setFoto(archivo.getBytes());
    	}
        this.service.save(db);
        return ResponseEntity.status(HttpStatus.CREATED).body(db);
}
    
    return ResponseEntity.notFound().build();
}
}
