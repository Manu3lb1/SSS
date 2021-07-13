package com.sss.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.InfoMedicaDAO;
import com.sss.entitys.InfoMedica;


@RestController
@RequestMapping("/infoMedica")

public class InfoMedicaREST {
	
	
	@Autowired
	private InfoMedicaDAO infoMedicaDAO;
	
	//Lista tabla info medica de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<InfoMedica>> getInfoMedica(){
		List<InfoMedica> infoMedica = infoMedicaDAO.findAll();
		return ResponseEntity.ok(infoMedica);
	}
	
	//Consulta por POST info medica de la base de datos por el ID
	@RequestMapping(value = "{idInfoMedica}") // im/infm
	public ResponseEntity<InfoMedica> getInfoMedicaById(@PathVariable("idInfoMedica") Long idInfoMedica) {
		Optional<InfoMedica> optionalInfoMedica = infoMedicaDAO.findById(idInfoMedica);
		if (optionalInfoMedica.isPresent()) {
			return ResponseEntity.ok(optionalInfoMedica.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	//Crear por POST una Sede a la base de datos
	@PostMapping 
	public ResponseEntity<InfoMedica> createInfoMedica(@RequestBody InfoMedica infoMedica){
		InfoMedica newInfoMedica =infoMedicaDAO.save(infoMedica);
		return ResponseEntity.ok(newInfoMedica);
	}
	
	
	//Actualizar por PUT una Sede de la base de datos
	
	@PutMapping
	public ResponseEntity<InfoMedica> updateInfoMedica(@RequestBody InfoMedica infoMedica){
		Optional<InfoMedica> optionalInfoMedica = infoMedicaDAO.findById(infoMedica.getIdInfMedica());
		if (optionalInfoMedica.isPresent()) {
			InfoMedica updateInfoMedica = optionalInfoMedica.get();
			updateInfoMedica.setHipertension(infoMedica.getHipertension());
			updateInfoMedica.setDiabetes(infoMedica.getDiabetes());
			updateInfoMedica.setObesidad(infoMedica.getObesidad());
			updateInfoMedica.setEnfPulmonares(infoMedica.getEnfPulmonares());
			updateInfoMedica.setEstEmbarazo(infoMedica.getEstEmbarazo());
			infoMedicaDAO.save(updateInfoMedica);
			return ResponseEntity.ok(updateInfoMedica);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}











