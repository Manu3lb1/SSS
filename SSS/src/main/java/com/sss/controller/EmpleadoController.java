package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.dao.EmpleadoDAO;
import com.sss.entitys.Empleado;

@CrossOrigin(origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@GetMapping
	public ResponseEntity<List<Empleado>> getEmpleado(){
		List<Empleado> Empleado = empleadoDAO.findAll();
		return ResponseEntity.ok(Empleado);
	}
	
	//Consulta por POST un Empleado de la base de datos por el ID
	@RequestMapping(value = "{idEmpleado}") // Empleado/idEmpleado
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("idEmpleado") Long idEmpleado) {
		Optional<Empleado> optionalEmpleado = empleadoDAO.findById(idEmpleado);
		if (optionalEmpleado.isPresent()) {
			return ResponseEntity.ok(optionalEmpleado.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	
	
	//Crear por POST un Empleado en la base de datos
	@PostMapping 
	public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado){
		Empleado newEmpleado =empleadoDAO.save(empleado);
		return ResponseEntity.ok(newEmpleado);
	}
	
	
	
	//Eliminar por DELETE un Empleado de la base de datos
	@DeleteMapping(value = "{idEmpleado}")
		public ResponseEntity<Void> deleteEmpleado(@PathVariable("idEmpleado") Long idEmpleado){
			empleadoDAO.deleteById(idEmpleado);
			return ResponseEntity.ok(null);
		}

	//Actualizar por PUT un Empleado de la base de datos
	@PutMapping
	public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleado){
		Optional<Empleado> optionalEmpleado = empleadoDAO.findById(empleado.getIdEmpleado());
		if (optionalEmpleado.isPresent()) {
			Empleado updateEmpleado = optionalEmpleado.get();
			updateEmpleado.setNombres(empleado.getNombres());
			updateEmpleado.setApellidos(empleado.getApellidos());
			updateEmpleado.setTipoDocumento(empleado.getTipoDocumento());
			updateEmpleado.setNumDocumento(empleado.getNumDocumento());
			updateEmpleado.setGenero(empleado.getGenero());
			updateEmpleado.setFechaNacimiento(empleado.getFechaNacimiento());
			updateEmpleado.setTipoContrato(empleado.getTipoContrato());
			updateEmpleado.setCargo(empleado.getCargo());
			updateEmpleado.setSalario(empleado.getSalario());
			updateEmpleado.setModalidadTrabajo(empleado.getModalidadTrabajo());
			updateEmpleado.setActivo(empleado.getActivo());
			updateEmpleado.setCorreo(empleado.getCorreo());
			updateEmpleado.setContrasena(empleado.getContrasena());
			empleadoDAO.save(updateEmpleado);
			return ResponseEntity.ok(updateEmpleado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}