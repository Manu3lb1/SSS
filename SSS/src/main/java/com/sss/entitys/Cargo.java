package com.sss.entitys;

import java.util.Date;

import javax.persistence.*;


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
	@Table( name = "CARGO")

public class Cargo {
		
		@Id
		@Column(name ="ID_CARGO")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idCargo;
		
		@Column(name ="NOMBRE_CARGO", nullable=false, length=50)
		private String nombreCargo;
		
		@Column(name ="FECHA_CARGO", nullable=false, length=50)
		private Date fechaCargo;
		
		@Column(name ="CARGO_ACTIVIDAD_ID", nullable=false, length=50)
		private Long cargoActividadId;
		
}






		
		


