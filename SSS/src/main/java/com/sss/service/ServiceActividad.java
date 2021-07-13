package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Actividad;

public interface ServiceActividad {
	
	public abstract List<Actividad> listAllActividad();
	public abstract Optional<Actividad>findByOptional(Long idActividad);
}
