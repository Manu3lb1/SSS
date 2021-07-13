package com.sss.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.entitys.Administrador;

//Con esta interfaz se implementa todas las funciones del CRUD de forma automatica.

@Repository ("administradorDao")

public interface AdministradorDAO extends CrudRepository<Administrador, Long>{

}
