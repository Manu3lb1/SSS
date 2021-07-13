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
	@Table( name = "PROCESO")

public class Proceso {
		
		
		@Id
		@Column(name ="ID_PROCESO")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idProceso;
		
		@Column(name ="PROCESO", nullable=false, length=30)
		private String proceso;
		
		/*
		@Column(name ="ADMIN_CLIENTE_ID")
		private long admin_cliente_id;*/
}







