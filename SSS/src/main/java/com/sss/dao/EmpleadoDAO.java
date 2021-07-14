package com.sss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sss.dto.EmpleadoAusentismoDTO;
import com.sss.dto.EmpleadoInfMedicaDTO;
import com.sss.dto.EmpleadoMatrizDTO;
import com.sss.entitys.Empleado;

//Con esta interfaz se implementa todas las funciones del CRUD de forma automatica.

@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado, Long> {

	@Query(value= ScriptsJPQL.FIND_BY_EMPLEADO_AUSENTISMO)
    public List<EmpleadoAusentismoDTO> findByAusentismoEmpleado (@Param("idEmpleado") Long idEmpleado);

	@Query(value= ScriptsJPQL.FIND_BY_EMPLEADO_INFMEDICA)
	public List<EmpleadoInfMedicaDTO> findByInfMedica(@Param("idEmpleado") Long idEmpleado);
	
	@Query(value= ScriptsJPQL.FIND_BY_EMPLEADO_MATRIZ)
	public List<EmpleadoMatrizDTO> findByMatriz(@Param("idEmpleado") Long idEmpleado);
	
}