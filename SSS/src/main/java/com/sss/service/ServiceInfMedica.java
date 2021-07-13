package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.InfoMedica;

public interface ServiceInfMedica {
	
	public abstract List<InfoMedica> listAllInfoMedicas();
	public abstract Optional<InfoMedica> findByOptional(Long idInfoMedica);

}
