package com.sss.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.SedeDAO;
import com.sss.entitys.Sede;


@RestController
@RequestMapping("/sede")
public class SedeREST {
	
	@Autowired
	private SedeDAO sedeDAO;
	
	//Lista tabla sede de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Sede>> getSede(){
		List<Sede> sede = sedeDAO.findAll();
		return ResponseEntity.ok(sede);
	}
	
	//Consulta por POST un sede de la base de datos por el ID
	@RequestMapping(value = "{idSede}") // sede/idSede
	public ResponseEntity<Sede> getSedeById(@PathVariable("idSede") Long idSede) {
		Optional<Sede> optionalSede = sedeDAO.findById(idSede);
		if (optionalSede.isPresent()) {
			return ResponseEntity.ok(optionalSede.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	//Crear por POST una Sede a la base de datos
	@PostMapping 
	public ResponseEntity<Sede> createSede(@RequestBody Sede sede){
		Sede newSede =sedeDAO.save(sede);
		return ResponseEntity.ok(newSede);
	}
	
	
	
	//Eliminar por DELETE una Sede de la base de datos
	@DeleteMapping(value = "{idSede}")
		public ResponseEntity<Void> deleteSede(@PathVariable("idSede") Long idSede){
			sedeDAO.deleteById(idSede);
			return ResponseEntity.ok(null);
		}
	
	//Actualizar por PUT una Sede de la base de datos
	
	@PutMapping
	public ResponseEntity<Sede> updateSede(@RequestBody Sede sede){
		Optional<Sede> optionalSede = sedeDAO.findById(sede.getIdSede());
		if (optionalSede.isPresent()) {
			Sede updateSede = optionalSede.get();
			updateSede.setNombreSede(sede.getNombreSede());
			updateSede.setCondicionJuridica(sede.getCondicionJuridica());
			updateSede.setDireccion(sede.getDireccion());
			sedeDAO.save(updateSede);
			return ResponseEntity.ok(updateSede);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

}









