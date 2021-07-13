package com.sss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sss.entitys.Cargo;

//Con esta interfaz se implementa todas las funciones del CRUD de forma automatica.

@Repository

public interface CargoDAO extends JpaRepository<Cargo, Long>{

}





