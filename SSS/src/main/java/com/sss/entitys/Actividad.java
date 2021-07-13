package com.sss.entitys;

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
	@Table( name = "ACTIVIDAD")

public class Actividad {

		@Id
		@Column(name ="ID_ACTIVIDAD")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idActividad;
		
		@Column(name ="NOMBRE_ACTIVIDAD", nullable=false, length=50)
		private String nombreActividad;
		
		@Column(name ="CRITICIDAD", nullable=false, length=50)
		private String criticidad;
		
}



