package com.sss.dao;

public class ScriptsJPQL {
	
	
	public static final String FIND_BY_EMPLEADO_AUSENTISMO=""
			+ "SELECT new com.sss.dto.EmpleadoAusentismoDTO("
			+ "e.idEmpleado, e.nombres, e.apellidos"
			+ ", e.tipoDocumento, e.numDocumento"
			+ ", a.fechaRegistro, a.causa, "
			+ "a.fechaInicio, a.fechaFin, a.dias, "
			+ "a.tipoIncapacidad"
			+ ") "
			+ "FROM Empleado as e "
			+ "INNER JOIN Ausentismo as a ON a.ausentismoEmpleadoId=e.idEmpleado ";
			//+ "WHERE e.idEmpleado=:idEmpleado";
	

	public static final String FIND_BY_EMPLEADO_INFMEDICA=""
			+ "SELECT new com.sss.dto.EmpleadoInfMedicaDTO("
			+ "e.idEmpleado, e.nombres, e.apellidos"
			+ ", e.tipoDocumento, e.numDocumento"
			+ ", i.hipertension, i.diabetes, i.obesidad"
			+ ", i.enfPulmonares, i.estEmbarazo"
			+ ") "
			+ "FROM Empleado as e "
			+ "INNER JOIN InfoMedica as i ON i.infMedicaEmpleadoId=e.idEmpleado ";
			//+ "WHERE e.idEmpleado=:idEmpleado";
	
	public static final String FIND_BY_EMPLEADO_MATRIZ=""
			+ "SELECT new com.sss.dto.EmpleadoMatrizDTO("
			+ "e.idEmpleado, e.nombres, e.apellidos"
			+ ", e.tipoDocumento, e.numDocumento"
			+ ", m.macroproceso, p.proceso"
			+ ", a.nombreActividad, a.criticidad"
			+ ", c.nombreCargo, c.fechaCargo"
			+ ") "
	        + "FROM Empleado as e "
	        + "INNER JOIN Macroproceso as m ON m.macroprocesoEmpleadoId=e.idEmpleado "
	        + "INNER JOIN Proceso as p ON p.procesoMacroprocesoId=m.idMacroproceso "
            + "INNER JOIN Actividad as a ON a.actividadProcesoId=p.idProceso "
	        + "INNER JOIN Cargo as c ON c.cargoActividadId=a.idActividad ";
	
	public static final String FIND_BY_CTRABAJO_EPP=""
			+ "SELECT new com.sss.dto.CtrabajoEppDTO("
			+ "ct.idCtrabajo, ct.centroTrabajo, e.nombreEpp"
			+ ", e.referencia, e.especificaciones, e.caracteristicas"
			+ ", e.proveedor, e.peligroCubre, e.parteProtege"
			+ ") "
	        + "FROM CTrabajo as ct "
	        + "INNER JOIN Empleado as em ON em.empleadoCtrabajoId=ct.idCtrabajo "
	        + "INNER JOIN Macroproceso as m ON m.macroprocesoEmpleadoId=em.idEmpleado "
	        + "INNER JOIN Proceso as p ON p.procesoMacroprocesoId=m.idMacroproceso "
            + "INNER JOIN Actividad as a ON a.actividadProcesoId=p.idProceso "
	        + "INNER JOIN Cargo as c ON c.cargoActividadId=a.idActividad "
	        + "INNER JOIN Epp as e ON e.eppCargoId=c.idCargo ";
			
			
//			SELECT CT.CENTRO_TRABAJO, E.NOMBRE_EPP, E.REFERENCIA, E.ESPECIFICACIONES,
//			E.CARACTERISTICAS, E.PROVEEDOR, E.PELIGRO_CUBRE, E.PARTE_PROTEGE
//			FROM CTRABAJO CT
//			INNER JOIN EMPLEADO EM ON EM.EMPLEADO_CTRABAJO_ID=CT.ID_CTRABAJO
//			INNER JOIN MACROPROCESO M ON M.MACROPROCESO_EMPLEADO_ID=EM.ID_EMPLEADO
//			INNER JOIN PROCESO P ON P.PROCESO_MACROPROCESO_ID=M.ID_MACROPROCESO
//			INNER JOIN ACTIVIDAD A ON A.ACTIVIDAD_PROCESO_ID=P.ID_PROCESO
//			INNER JOIN CARGO C ON C.CARGO_ACTIVIDAD_ID=A.ID_ACTIVIDAD
//			INNER JOIN EPP E ON E.EPP_CARGO_ID=C.ID_CARGO;
			
}


