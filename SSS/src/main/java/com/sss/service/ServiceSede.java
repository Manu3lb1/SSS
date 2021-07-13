package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Sede;

public interface ServiceSede {
	
	public abstract List<Sede> listAllSede();
	public abstract Optional<Sede> findByOptional(Long idSede);
}
