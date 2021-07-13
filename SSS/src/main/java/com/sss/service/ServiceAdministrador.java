package com.sss.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.sss.entitys.Administrador;

public interface ServiceAdministrador {
	
	public ResponseEntity listAllAdministradors();
	public abstract Optional<Administrador> findByOptional(Long idAdmin);
	public abstract Administrador updateAdministrador (Administrador administrador);
    public abstract int removeAdministrador(Long id_admin);
}
