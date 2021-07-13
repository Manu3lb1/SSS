package com.sss.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones Lombok
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor

public class EmpleadoAusentismoDTO {

	private Long idEmpleado;
	private String nombres;
	private String apellidos;
	private Date fechaRegistro;
	private String causa;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer dias;
	private String tipoIncapacidad;
	
}
