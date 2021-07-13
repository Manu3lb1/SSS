package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Epp;

public interface ServiceEpp {
	
	public abstract List<Epp>findByAll();
	public abstract Optional<Epp> findByOptional(Long idEpp);

}
