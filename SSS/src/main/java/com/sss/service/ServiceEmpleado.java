package com.sss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.entitys.Empleado;


//@CrossOrigin   (origins = "http://localhost:4200", maxAge =3600)
//@RestController
//@RequestMapping("/empleado")
public interface ServiceEmpleado {
	//Lista tabla empleado de la base de datos SSS
		@GetMapping
	public ResponseEntity<List<Empleado>> listAllEmpleado();
//	public abstract Optional<Empleado> findByOptional(Long idEmpleado);
//	public abstract Empleado updateAdministrador (Empleado empleado);
//    public abstract int removeAdministrador(Long idEmpleado);

}
