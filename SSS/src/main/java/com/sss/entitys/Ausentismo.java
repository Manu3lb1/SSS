package com.sss.entitys;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Table( name = "Ausentismo")

public class Ausentismo {
		
		@Id
		@Column(name ="ID_AUSENTISMO")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idAusentismo;
		
		@Column(name ="FECHA_REGISTRO", nullable=false, length=50)
		private Date fechaRegistro;
		
		@Column(name ="CAUSA", nullable=false, length=50)
		private String causa;
		
		@Column(name ="FECHA_INICIO", nullable=false, length=30)
		private Date fechaInicio;
		
		@Column(name ="FECHA_FIN", nullable=false, length=30)
		private Date fechaFin;
		
		@Column(name ="DIAS", nullable=false, length=30)
		private Integer dias;
		
		@Column(name ="TIPO_INCAPACIDAD", nullable=false, length=30)
		private String tipoIncapacidad;
		
		@Column(name ="AUSENTISMO_EMPLEADO_ID", nullable = false)
		private Long ausentismoEmpleadoId;

}










		



