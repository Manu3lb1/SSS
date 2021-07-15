package com.sss.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones Lombok
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	
public class EmpleadoInfMedicaDTO {

		private Long idEmpleado;
		private String nombres;
		private String apellidos;
		private String tipoDocumento;
		private String numDocumento;
		private String hipertension;
		private String diabetes;
		private String obesidad;
		private String enfPulmonares;
		private String estEmbarazo;
}
