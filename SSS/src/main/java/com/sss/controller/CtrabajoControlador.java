package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.dao.CtrabajoDAO;
import com.sss.entitys.CTrabajo;


@CrossOrigin(origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/trabajo")
public class CtrabajoControlador {

	@Autowired
	private CtrabajoDAO ctrabajoDAO;

	
	//Lista tabla empleados de la base de datos SSS
		@GetMapping
		public ResponseEntity<List<CTrabajo>> getCtrabajo(){
			List<CTrabajo> ctrabajo = (List<CTrabajo>) ctrabajoDAO.findAll();
			return ResponseEntity.ok(ctrabajo);
		}
		
		//Consulta por POST un administrador de la base de datos por el ID
		@RequestMapping(value = "{idCtrabajo}") // centro de trabajo/id_admin
		public ResponseEntity<CTrabajo> getCtrabajoById(@PathVariable("idCtrabajo") Long idCtrabajo) {
			Optional<CTrabajo> optionalCtrabajo = ctrabajoDAO.findById(idCtrabajo);
			if (optionalCtrabajo.isPresent()) {
				return ResponseEntity.ok(optionalCtrabajo.get());
			} else {
				return ResponseEntity.noContent().build();
			}

		}
	
}
