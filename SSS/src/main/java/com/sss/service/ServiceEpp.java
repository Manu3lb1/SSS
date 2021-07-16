package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Epp;

public interface ServiceEpp {
	
	public  List<Epp>findByAll();
	public  Optional<Epp> findByOptional(Long idEpp);	

}
