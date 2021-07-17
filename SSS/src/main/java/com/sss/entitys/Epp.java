package com.sss.entitys;

import javax.persistence.*;

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
	
	//Anotaciones de JPA
	@Entity
	@Table( name = "EPP")

public class Epp {
		

		@Id
		@Column(name ="ID_EPP")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idEpp;
		
		@Column(name ="NOMBRE_EPP", nullable=false, length=50)
		private String nombreEpp;
		
		@Column(name ="REFERENCIA", nullable=false, length=50)
		private String referencia;
		
		@Column(name ="ESPECIFICACIONES", nullable=false, length=30)
		private String especificaciones;
		
		@Column(name ="CARACTERISTICAS", nullable=false, length=30)
		private String caracteristicas;
		
		@Column(name ="PROVEEDOR", nullable=false, length=30)
		private String proveedor;
		
		@Column(name ="PELIGRO_CUBRE", nullable=false, length=30)
		private String peligroCubre;
		
		@Column(name ="PARTE_PROTEGE", nullable=false, length=30)
		private String parteProtege;
		
//		@Column(name ="EPP_CARGO_ID", nullable=false, length=50)
		@Column(name ="EPP_CARGO_ID", length=50)
		private Long eppCargoId;
		
}









