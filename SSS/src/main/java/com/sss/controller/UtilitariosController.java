package com.sss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.dao.EmpleadoDAO;
import com.sss.dto.EmpleadoAusentismoDTO;
import com.sss.dto.EmpleadoInfMedicaDTO;
import com.sss.dto.EmpleadoMatrizDTO;

@CrossOrigin   (origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/utilitario")
public class UtilitariosController {

	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@CrossOrigin
	@GetMapping("ausentismo")
	public ResponseEntity<List<EmpleadoAusentismoDTO>> getAusentismoEmpleado(){
		//List<Empleado> Empleado = empleadoDAO.findAll();
		List<EmpleadoAusentismoDTO> Empleado = empleadoDAO.findByAusentismoEmpleado(10027L);
		return ResponseEntity.ok(Empleado);
	}
	
	@CrossOrigin
	@GetMapping("medica")
	public ResponseEntity<List<EmpleadoInfMedicaDTO>> getMedicaEmpleado(){
		//List<Empleado> Empleado = empleadoDAO.findAll();
		List<EmpleadoInfMedicaDTO> Empleado = empleadoDAO.findByInfMedica(10027L);
		return ResponseEntity.ok(Empleado);
	}
	
	@CrossOrigin
	@GetMapping("matriz")
	public ResponseEntity<List<EmpleadoMatrizDTO>> getMatrizEmpleado(){
		//List<Empleado> Empleado = empleadoDAO.findAll();
		List<EmpleadoMatrizDTO> Empleado = empleadoDAO.findByMatriz(10027L);
		return ResponseEntity.ok(Empleado);
	}
}
