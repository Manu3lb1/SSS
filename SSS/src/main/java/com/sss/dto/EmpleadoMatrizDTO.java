package com.sss.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones Lombok
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor

public class EmpleadoMatrizDTO {

	private Long idEmpleado;
	private String nombres;
	private String apellidos;
	private String tipoDocumento;
	private String numDocumento;
	private String macroproceso;
	private String proceso;
	private String nombreActividad;
	private String criticidad;
	private String nombreCargo;
	private Date fechaCargo;
}

	