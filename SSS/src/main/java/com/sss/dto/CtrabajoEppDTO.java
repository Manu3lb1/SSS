package com.sss.dto;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones Lombok
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor

public class CtrabajoEppDTO {
	
		
		@CsvBindByPosition(position = 0)
		private String nombreEpp;
		@CsvBindByPosition(position = 1)
		private String referencia;
		@CsvBindByPosition(position = 2)
		private String especificaciones;
		@CsvBindByPosition(position = 3)
		private String caracteristicas;
		@CsvBindByPosition(position = 4)
		private String proveedor;
		@CsvBindByPosition(position = 5)
		private String peligroCubre;
		@CsvBindByPosition(position = 6)
		private String parteProtege;
		
}
