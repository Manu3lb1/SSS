package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Ausentismo;

public interface ServiceAusentismo {
	
	public abstract List<Ausentismo> ListAllAusentismos();
	public abstract Optional<Ausentismo> findByIdOptional(Long idAusentismo);

}
