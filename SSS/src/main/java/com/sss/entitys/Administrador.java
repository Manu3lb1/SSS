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
	@Table( name = "ADMINISTRADOR")
	
public class Administrador {
	
	@Id
	@Column(name ="ID_ADMIN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdmin;
	
	@Column(name ="NOMBRES", nullable=false, length=50)
	private String nombres;
	
	@Column(name ="APELLIDOS", nullable=false, length=50)
	private String apellidos;
	
	@Column(name ="CONTRASENA", nullable=false, length=30)
	private String contrasena;
	
	@Column(name ="CORREO", nullable=false, length=50)
	private String correo;
	
	/*
	@Column(name ="ADMIN_CLIENTE_ID")
	private long admin_cliente_id;*/
	
	
}
