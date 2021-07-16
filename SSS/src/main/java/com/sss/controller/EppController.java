package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sss.csv.CSV;
import com.sss.dao.EppDAO;
import com.sss.entitys.Epp;
import com.sss.mensaje.EppMensaje;
import com.sss.service.impl.CargarServicio;

@CrossOrigin(origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/epp")
public class EppController {

	@Autowired
	private EppDAO eppDAO;
	@Autowired
	private CargarServicio cargarServicio;
	
	//Lista tabla epp de la base de datos SSS
	@GetMapping("mostrar")
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
	
	@PostMapping("cargar")
	 public ResponseEntity<EppMensaje> uploadFile(@RequestParam("file") MultipartFile file) {
	    String mensaje = "";

	    if (CSV.hasCSVFormat(file)) {
	      try {
	        cargarServicio.save(file);

	        mensaje = "Subió el archivo con éxito: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new EppMensaje(mensaje));
	      } catch (Exception e) {
	        mensaje = "No se pudo cargar el archivo: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new EppMensaje(mensaje));
	      }
	    }

	    mensaje = "¡Sube un archivo csv!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EppMensaje(mensaje));
	  }
	
	@GetMapping("/epps")
	  public ResponseEntity<List<Epp>> getAllEpps() {
	    try {
	      List<Epp> epps = cargarServicio.getAllEpps();

	      if (epps.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(epps, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


    @GetMapping("descargar")
    public String descargar (@RequestParam("archivos") MultipartFile file) {
		return"epp";
    }
	

}
