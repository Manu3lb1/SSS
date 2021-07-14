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
			+ "INNER JOIN Ausentismo as a ON a.ausentismoEmpleadoId=e.idEmpleado "
			+ "WHERE e.idEmpleado=:idEmpleado";
	

	public static final String FIND_BY_EMPLEADO_INFMEDICA=""
			+ "SELECT new com.sss.dto.EmpleadoInfMedicaDTO("
			+ "e.idEmpleado, e.nombres, e.apellidos"
			+ ", i.hipertension, i.diabetes, i.obesidad"
			+ ", i.enfPulmonares, i.estEmbarazo"
			+ ") "
			+ "FROM Empleado as e "
			+ "INNER JOIN InfoMedica as i ON i.infMedicaEmpleadoId=e.idEmpleado "
			+ "WHERE e.idEmpleado=:idEmpleado";
	
	public static final String FIND_BY_EMPLEADO_MATRIZ=""
			+ "SELECT new com.sss.dto.EmpleadoMatrizDTO("
			+ "e.idEmpleado, e.nombres, e.apellidos"
			+ ", m.centroTrabajo, m.macroproceso, p.proceso"
			+ ", a.nombreActividad, a.criticidad"
			+ ", c.nombreCargo, c.fechaCargo"
			+ ") "
	        + "FROM Empleado as e "
	        + "INNER JOIN Macroproceso as m ON m.macroprocesoEmpleadoId=e.idEmpleado "
	        + "INNER JOIN Proceso as p ON p.procesoMacroprocesoId=m.idMacroproceso "
            + "INNER JOIN Actividad as a ON a.actividadProcesoId=p.idProceso "
	        + "INNER JOIN Cargo as c ON c.cargoActividadId=a.idActividad ";
//			 M.CENTRO_TRABAJO, M.MACROPROCESO,
//			P.PROCESO, A.NOMBRE_ACTIVIDAD, A.CRITICIDAD, C.NOMBRE_CARGO, C.FECHA_CARGO
//			FROM EMPLEADO E
//			INNER JOIN MACROPROCESO M ON M.MACROPROCESO_EMPLEADO_ID=E.ID_EMPLEADO
//			INNER JOIN PROCESO P ON P.PROCESO_MACROPROCESO_ID=M.ID_MACROPROCESO
//			INNER JOIN ACTIVIDAD A ON A.ACTIVIDAD_PROCESO_ID=P.ID_PROCESO
//			INNER JOIN CARGO C ON C.CARGO_ACTIVIDAD_ID=A.ID_ACTIVIDAD
//			WHERE E.ID_EMPLEADO=10003;
			
}


