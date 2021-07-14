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
	@Table( name = "SEDE")

public class Sede {
		
		@Id
		@Column(name ="ID_SEDE")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idSede;
		
		@Column(name ="NOMBRE_SEDE", nullable=false, length=50)
		private String nombreSede;
		
		@Column(name ="CONDICION_JURIDICA", nullable=false, length=50)
		private String condicionJuridica;
		
		@Column(name ="DIRECCION", nullable=false, length=30)
		private String direccion;
		
		@Column(name ="SEDE_CLIENTE_ID", nullable=false, length=50)
		private Long sedeClienteId;
		
		/*
		@Column(name ="ADMIN_CLIENTE_ID")
		private long admin_cliente_id;*/

}



	
