package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.AusentismoDAO;
import com.sss.entitys.Ausentismo;


@RestController
@RequestMapping("/ausentismo")

public class AusentismoController {
	
	@Autowired
	private AusentismoDAO ausentismoDAO;
	
	//Lista tabla ausentismo de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Ausentismo>> getAusentismo(){
		List<Ausentismo> ausentismo = ausentismoDAO.findAll();
		return ResponseEntity.ok(ausentismo);
	}
	
	//Consulta por POST ausentismo de la base de datos por el ID
	@RequestMapping(value = "{idAusentismo}") // ausentismo/idAusentismo
	public ResponseEntity<Ausentismo> getAusentismoById(@PathVariable("idAusentismo") Long idAusentismo) {
		Optional<Ausentismo> optionalAusentismo = ausentismoDAO.findById(idAusentismo);
		if (optionalAusentismo.isPresent()) {
			return ResponseEntity.ok(optionalAusentismo.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	//Crear por POST ausentismo a la base de datos
	@PostMapping 
	public ResponseEntity<Ausentismo> createSede(@RequestBody Ausentismo ausentismo){
		Ausentismo newAusentismo =ausentismoDAO.save(ausentismo);
		return ResponseEntity.ok(newAusentismo);
	}
	
	//Actualizar por PUT una Sede de la base de datos
	
	@PutMapping
	public ResponseEntity<Ausentismo> updateAusentismo(@RequestBody Ausentismo ausentismo){
		Optional<Ausentismo> optionalAusentismo = ausentismoDAO.findById(ausentismo.getIdAusentismo());
		if (optionalAusentismo.isPresent()) {
			Ausentismo updateAusentismo = optionalAusentismo.get();
			updateAusentismo.setFechaRegistro(ausentismo.getFechaRegistro());
			updateAusentismo.setCausa(ausentismo.getCausa());
			updateAusentismo.setFechaInicio(ausentismo.getFechaInicio());
			updateAusentismo.setFechaFin(ausentismo.getFechaFin());
			updateAusentismo.setDias(ausentismo.getDias());
			updateAusentismo.setTipoIncapacidad(ausentismo.getTipoIncapacidad());
			
			ausentismoDAO.save(updateAusentismo);
			return ResponseEntity.ok(updateAusentismo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}








	

