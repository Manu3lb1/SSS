package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Proceso;

public interface ServiceProceso {
	
	public abstract List<Proceso> listAllProceso();
	public abstract Optional<Proceso> findOptional (Long idProceso);

}
