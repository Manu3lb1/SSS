package com.sss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sss.entitys.Actividad;

//Con esta interfaz se implementa todas las funciones del CRUD de forma automatica.

@Repository("administradorRepository")

public interface ActividadDAO extends JpaRepository<Actividad, Long>{

//	@Query
//	public void buscar();
	
}