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
	@Table( name = "CTRABAJO")

public class CTrabajo {
		
		@Id
		@Column(name ="ID_CTRABAJO")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idCtrabajo;
		
		@Column(name ="CENTRO_TRABAJO", nullable=false, length=50)
		private String centroTrabajo;
	
		@Column(name ="CTRABAJO_SEDE_ID", nullable=false, length=50)
		private Long ctrabajoSedeId;

}
