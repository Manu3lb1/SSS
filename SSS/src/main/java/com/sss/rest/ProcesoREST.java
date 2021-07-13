package com.sss.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.ProcesoDAO;
import com.sss.entitys.Proceso;


@RestController
@RequestMapping("/proceso")

public class ProcesoREST {
	
	@Autowired
	private ProcesoDAO procesoDAO;
	
	//Lista tabla proceso de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Proceso>> getProceso(){
		List<Proceso> proceso = procesoDAO.findAll();
		return ResponseEntity.ok(proceso);
	}
	
	//Consulta por POST un proceso de la base de datos por el ID
	@RequestMapping(value = "{idProceso}") // proceso/idProceso
	public ResponseEntity<Proceso> getProcesoById(@PathVariable("idProceso") Long idProceso) {
		Optional<Proceso> optionalProceso = procesoDAO.findById(idProceso);
		if (optionalProceso.isPresent()) {
			return ResponseEntity.ok(optionalProceso.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	//Crear por POST una Proceso a la base de datos
	@PostMapping 
	public ResponseEntity<Proceso> createProceso(@RequestBody Proceso proceso){
		Proceso newProceso =procesoDAO.save(proceso);
		return ResponseEntity.ok(newProceso);
	}
	
	
	
	//Eliminar por DELETE un Proceso de la base de datos
	@DeleteMapping(value = "{idProceso}")
		public ResponseEntity<Void> deleteProceso(@PathVariable("idProceso") Long idProceso){
			procesoDAO.deleteById(idProceso);
			return ResponseEntity.ok(null);
		}
	
	//Actualizar por PUT un Proceso de la base de datos
	
	@PutMapping
	public ResponseEntity<Proceso> updateProceso(@RequestBody Proceso proceso){
		Optional<Proceso> optionalProceso = procesoDAO.findById(proceso.getIdProceso());
		if (optionalProceso.isPresent()) {
			Proceso updateProceso = optionalProceso.get();
			updateProceso.setProceso(proceso.getProceso());
			procesoDAO.save(updateProceso);
			return ResponseEntity.ok(updateProceso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

}




	

	


