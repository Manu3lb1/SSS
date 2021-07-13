package com.sss.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.AdministradorDAO;
import com.sss.entitys.Administrador;

@CrossOrigin(origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/administrador")
public class AdministradorREST {

	@Autowired
	private AdministradorDAO administradorDAO;
	
	//Lista tabla empleados de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Administrador>> getAdministrador(){
		List<Administrador> administrador = (List<Administrador>) administradorDAO.findAll();
		return ResponseEntity.ok(administrador);
	}
	
	//Consulta por POST un administrador de la base de datos por el ID
	@RequestMapping(value = "{idAdmin}") // administrador/id_admin
	public ResponseEntity<Administrador> getAdministradorById(@PathVariable("idAdmin") Long idAdmin) {
		Optional<Administrador> optionalAdministrador = administradorDAO.findById(idAdmin);
		if (optionalAdministrador.isPresent()) {
			return ResponseEntity.ok(optionalAdministrador.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	//Crear por POST un Administrador a la base de datos
	@PostMapping 
	public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador){
		Administrador newAdministrador =administradorDAO.save(administrador);
		return ResponseEntity.ok(newAdministrador);
	}
	
	
	
	//Eliminar por DELETE un Administrador de la base de datos
	@DeleteMapping(value = "{idAdmin}")
		public ResponseEntity<Void> deleteAdministrador(@PathVariable("idAdmin") Long idAdmin){
			administradorDAO.deleteById(idAdmin);
			return ResponseEntity.ok(null);
		}
	
	//Actualizar por PUT un Adminitrador de la base de datos
	
//	@PutMapping
//	public ResponseEntity<Administrador> updateAdministrador(@RequestBody Administrador administrador){
//		Optional<Administrador> optionalAdministrador = administradorDAO.findById(administrador.getIdAdmin());
//		if (optionalAdministrador.isPresent()) {
//			Administrador updateAdministrador = optionalAdministrador.get();
//			updateAdministrador.setNombres(administrador.getNombres());
//			updateAdministrador.setApellidos(administrador.getApellidos());
//			updateAdministrador.setCorreo(administrador.getCorreo());
//			updateAdministrador.setContrasena(administrador.getContrasena());
//			administradorDAO.save(updateAdministrador);
//			return ResponseEntity.ok(updateAdministrador);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

}
