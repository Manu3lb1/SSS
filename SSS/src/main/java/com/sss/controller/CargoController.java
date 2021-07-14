package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.CargoDAO;
import com.sss.entitys.Cargo;


@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoDAO cargoDAO;
	
	//Lista tabla cargo de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Cargo>> getCargo(){
		List<Cargo> Cargo = cargoDAO.findAll();
		return ResponseEntity.ok(Cargo);
	}
	
	//Consulta por POST un cargo de la base de datos por el ID
	@RequestMapping(value = "{idCargo}") // cargo/idCargo
	public ResponseEntity<Cargo> getCargoById(@PathVariable("idCargo") Long idCargo) {
		Optional<Cargo> optionalCargo = cargoDAO.findById(idCargo);
		if (optionalCargo.isPresent()) {
			return ResponseEntity.ok(optionalCargo.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
}




	


