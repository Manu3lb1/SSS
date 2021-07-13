package com.sss.rest;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sss.dao.ClienteDAO;
import com.sss.entitys.Cliente;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins ="http://localhost:4200" )
public class ClienteREST {

	@Autowired
	private ClienteDAO clienteDAO;
	
	//Lista tabla cliente de la base de datos SSS
	@GetMapping
	public ResponseEntity<List<Cliente>> getCliente(){
		List<Cliente> Cliente = clienteDAO.findAll();
		return ResponseEntity.ok(Cliente);
	}
	
	//Consulta por POST un Cliente de la base de datos por el ID
	@RequestMapping(value = "{idCliente}") // Cliente/idCliente
	public ResponseEntity<Cliente> getClienteById(@PathVariable("idCliente") Long idCliente) {
		Optional<Cliente> optionalCliente = clienteDAO.findById(idCliente);
		if (optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	
	
	//Crear por POST un Cliente a la base de datos
	@PostMapping 
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
		Cliente newCliente =clienteDAO.save(cliente);
		return ResponseEntity.ok(newCliente);
	}
	
	
	
	//Eliminar por DELETE un Cliente de la base de datos
	@DeleteMapping(value = "{idCliente}")
		public ResponseEntity<Void> deleteCliente(@PathVariable("idCliente") Long idCliente){
			clienteDAO.deleteById(idCliente);
			return ResponseEntity.ok(null);
		}

	//Actualizar por PUT un Cliente de la base de datos
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
		Optional<Cliente> optionalCliente = clienteDAO.findById(cliente.getIdCliente());
		if (optionalCliente.isPresent()) {
			Cliente updateCliente = optionalCliente.get();
			updateCliente.setNit(cliente.getNit());
			updateCliente.setRazonSocial(cliente.getRazonSocial());
			updateCliente.setPais(cliente.getPais());
			updateCliente.setDepartamento(cliente.getDepartamento());
			updateCliente.setCiudad(cliente.getCiudad());
			updateCliente.setActEconomica(cliente.getActEconomica());
			updateCliente.setNumeroTrabajadores(cliente.getNumeroTrabajadores());
			updateCliente.setClaseRiesgo(cliente.getClaseRiesgo());
			updateCliente.setCorreo(cliente.getCorreo());
			updateCliente.setContrasena(cliente.getContrasena());
			clienteDAO.save(updateCliente);
			return ResponseEntity.ok(updateCliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}