package com.sss.service;

import java.util.List;
import java.util.Optional;

import com.sss.entitys.Cargo;

public interface ServiceCargo {

	public abstract List<Cargo>listAllCargo();
	public abstract Optional<Cargo>findByOptional(Long idCargo);
}
