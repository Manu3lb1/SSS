package com.sss.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.sss.entitys.Administrador;

public interface ServiceAdministrador {
	
	public ResponseEntity<Administrador> listAllAdministradors();
	public Optional<Administrador> findByOptional(Long idAdmin);
	public Administrador updateAdministrador (Administrador administrador);
    public int removeAdministrador(Long id_admin);
}
