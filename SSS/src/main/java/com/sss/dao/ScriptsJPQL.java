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
			
			
}


