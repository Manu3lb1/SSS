package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sss.dao.EppDAO;
import com.sss.entitys.Epp;

@CrossOrigin(origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/epp-mostrar")

public class EppController {

	@Autowired
	private EppDAO eppDAO;
	
	//Lista tabla epp de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Epp>> getEpp(){
		List<Epp> epp = eppDAO.findAll();
		return ResponseEntity.ok(epp);
	}
	
	//Consulta por POST un epp de la base de datos por el ID
	@RequestMapping(value = "{idEpp}") // epp/idEpp
	public ResponseEntity<Epp> getEppById(@PathVariable("idEpp") Long idEpp) {
		Optional<Epp> optionalEpp = eppDAO.findById(idEpp);
		if (optionalEpp.isPresent()) {
			return ResponseEntity.ok(optionalEpp.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	@PostMapping("/cargar")
    public String carga (@RequestParam("archivos") MultipartFile file) {
			return"epp";
    }

    @GetMapping("/descargar")
    public String descargar (@RequestParam("archivos") MultipartFile file) {
		return"epp";
    }
	

}
