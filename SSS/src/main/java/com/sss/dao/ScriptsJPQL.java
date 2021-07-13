package com.sss.dao;

public class ScriptsJPQL {
	
	public static final String FIND_BY_EMPLEADO_AUSENTISMO=""
			+ "SELECT new com.sss.dto.EmpleadoAusentismoDTO("
			+ "e.idEmpleado, e.nombres, e.apellidos"
			+ ", a.fechaRegistro, a.causa, "
			+ "a.fechaInicio, a.fechaFin, a.dias, "
			+ "a.tipoIncapacidad"
			+ ") "
			+ "FROM Empleado as e "
			+ "INNER JOIN Ausentismo as a ON a.empleadoId=e.idEmpleado "
			+ "WHERE e.idEmpleado=:idEmpleado";
	

//	public static final String FIND_BY_EMPLEADO_AUSENTISMO=""
//			+ "SELECT new com.sss.dto.EmpleadoAusentismoDTO ("
//			+ "e.idEmpleado, e.nombres) from Empleado as e where e.idEmpleado=:idEmpleado";
}


