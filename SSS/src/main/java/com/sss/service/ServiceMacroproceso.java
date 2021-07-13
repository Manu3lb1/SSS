package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Macroproceso;

public interface ServiceMacroproceso {
	
	public abstract List<Macroproceso> listAllMacroproceso();
	public abstract Optional<Macroproceso> findByOptional(Long idMacroproceso);

}
