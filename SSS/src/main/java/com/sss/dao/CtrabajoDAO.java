package com.sss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sss.entitys.CTrabajo;


//Con esta interfaz se implementa todas las funciones del CRUD de forma automatica.

public interface CtrabajoDAO extends JpaRepository<CTrabajo, Long>{
	
//	@Query(value= ScriptsJPQL.FIND_BY_CTRABAJO_EPP)
//    public List<CtrabajoEppDTO> findByCtrabajoEpp (@Param("idCtrabajo") Long idCtrabajo);
	
	
//	public CTrabajo findByIdCtrabajo(@Param("idCtrabajo") Long idCtrabajo);
}

