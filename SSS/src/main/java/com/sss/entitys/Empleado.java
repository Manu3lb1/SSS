package com.sss.entitys;

import java.sql.Date;

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
	@Table( name = "EMPLEADO")

public class Empleado {

		@Id
		@Column(name ="ID_EMPLEADO")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idEmpleado;
		
		@Column(name ="NOMBRES", nullable=false, length=50)
		private String nombres;
		
		@Column(name ="APELLIDOS", nullable=false, length=50)
		private String apellidos;
		
		@Column(name ="TIPO_DOCUMENTO", nullable=false, length=50)
		private String tipoDocumento;
		
		@Column(name ="NUM_DOCUMENTO", nullable=false, length=50)
		private String numDocumento;
		
		@Column(name ="GENERO", nullable=false, length=50)
		private String genero;
		
		@Column(name ="FECHA_NACIMIENTO", nullable=false, length=50)
		private  Date fechaNacimiento;
		
		@Column(name ="TIPO_CONTRATO", nullable=false, length=50)
		private String tipoContrato;
		
		@Column(name ="CARGO", nullable=false, length=50)
		private String cargo;
		
		@Column(name ="SALARIO", nullable=false, length=30)
		private String salario;
		
		@Column(name ="MODALIDAD_TRABAJO", nullable=false, length=50)
		private String modalidadTrabajo;
		
		@Column(name ="ACTIVO", nullable=false, length=50)
		private String activo;
		
		@Column(name ="CORREO", nullable=false, length=50)
		private String correo;
		
		@Column(name ="CONTRASENA", nullable=false, length=30)
		private String contrasena;
		
}