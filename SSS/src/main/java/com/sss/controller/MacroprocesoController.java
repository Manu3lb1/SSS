package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.MacroprocesoDAO;
import com.sss.entitys.Macroproceso;

@RestController
@RequestMapping("/macroproceso")

public class MacroprocesoController {

	
	@Autowired
	private MacroprocesoDAO macroprocesoDAO;
	
	//Lista tabla proceso de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Macroproceso>> getMacroproceso(){
		List<Macroproceso> macroproceso = macroprocesoDAO.findAll();
		return ResponseEntity.ok(macroproceso);
	}
	
	//Consulta por POST un macroproceso de la base de datos por el ID
	@RequestMapping(value = "{idMacroproceso}") // macroproceso/idMacroroceso
	public ResponseEntity<Macroproceso> getMacroprocesoById(@PathVariable("idMacroproceso") Long idMacroproceso) {
		Optional<Macroproceso> optionalMacroproceso = macroprocesoDAO.findById(idMacroproceso);
		if (optionalMacroproceso.isPresent()) {
			return ResponseEntity.ok(optionalMacroproceso.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
}
