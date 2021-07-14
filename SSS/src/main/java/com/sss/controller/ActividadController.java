package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.ActividadDAO;
import com.sss.entitys.Actividad;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	private ActividadDAO actividadDAO;
	
	//Lista tabla actividad de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Actividad>> getActividad(){
		List<Actividad> Actividad = actividadDAO.findAll();
		return ResponseEntity.ok(Actividad);
	}
	
	//Consulta por POST una actividad de la base de datos por el ID
	@RequestMapping(value = "{idActividad}") // actividad/idActividad
	public ResponseEntity<Actividad> getActividadById(@PathVariable("idActividad") Long idActividad) {
		Optional<Actividad> optionalActividad = actividadDAO.findById(idActividad);
		if (optionalActividad.isPresent()) {
			return ResponseEntity.ok(optionalActividad.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}

}









