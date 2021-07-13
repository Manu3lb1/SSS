package com.sss.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.dao.EmpleadoDAO;
import com.sss.dto.EmpleadoAusentismoDTO;
import com.sss.entitys.Empleado;

@CrossOrigin   (origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/utilitario")
public class UtilitariosREST {

	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@GetMapping
	public ResponseEntity<List<EmpleadoAusentismoDTO>> getEmpleado2(){
		//List<Empleado> Empleado = empleadoDAO.findAll();
		List<EmpleadoAusentismoDTO> Empleado = empleadoDAO.findByAusentismoEmpleado(10026L);
		return ResponseEntity.ok(Empleado);
	}
	

}
