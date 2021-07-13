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
	@Table( name = "CLIENTE")


public class Cliente {

	
	@Id
	@Column(name ="ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(name ="NIT", nullable=false, length=50)
	private String nit;
	
	@Column(name ="RAZON_SOCIAL", nullable=false, length=50)
	private String razonSocial;
	
	@Column(name ="PAIS", nullable=false, length=30)
	private String pais;
	
	@Column(name ="DEPARTAMENTO", nullable=false, length=50)
	private String departamento;
	
	@Column(name ="CIUDAD", nullable=false, length=50)
	private String ciudad;
	
	@Column(name ="ACT_ECONOMICA", nullable=false, length=50)
	private String actEconomica;
	
	@Column(name ="NUMERO_TRABAJADORES", nullable=false, length=50)
	private String numeroTrabajadores;
	
	@Column(name ="CLASE_RIESGO", nullable=false, length=50)
	private String claseRiesgo;
	
	@Column(name ="CORREO", nullable=false, length=50)
	private String correo;
	
	@Column(name ="CONTRASENA", nullable=false, length=50)
	private String contrasena;
	
}
