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
	@Table( name = "INF_MEDICA")

public class InfoMedica {
	
		@Id
		@Column(name ="ID_INF_MEDICA")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idInfMedica;
		
		@Column(name ="HIPERTENSION", nullable=false, length=50)
		private String hipertension;
		
		@Column(name ="DIABETES", nullable=false, length=50)
		private String diabetes;
		
		@Column(name ="OBESIDAD", nullable=false, length=30)
		private String obesidad;
		
		@Column(name ="ENF_PULMONARES", nullable=false, length=50)
		private String enfPulmonares;
		
		@Column(name ="EST_EMBARAZO", nullable=false, length=30)
		private String estEmbarazo;

}
