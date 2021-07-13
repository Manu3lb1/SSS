package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Cliente;

public interface ServiceCliente {
	
	public abstract List<Cliente> listAllCliente();
	public abstract Optional<Cliente> findOptional(Long idCliente);

}
