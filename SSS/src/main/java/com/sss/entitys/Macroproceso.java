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
	@Table( name = "MACROPROCESO")

public class Macroproceso {
	
	@Id
	@Column(name="ID_MACROPROCESO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMacroproceso;
	
	@Column(name ="CENTRO_TRABAJO", nullable = false, length=50)
	private String centroTrabajo;
	
	@Column(name ="MACROPROCESO", nullable = false, length = 50)
	private String macroproceso;
	
	@Column(name ="MACROPROCESO_EMPLEADO_ID", nullable=false, length=50)
	private Long macroprocesoEmpleadoId;

}
