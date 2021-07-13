package com.sss.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.sss.entitys.Empleado;
import com.sss.rest.EmpleadoREST;
import com.sss.service.ServiceEmpleado;

public class ServiceEmpleadoImpl implements ServiceEmpleado{

	@Override
	public ResponseEntity<List<Empleado>> listAllEmpleado() {
		EmpleadoREST emp = new EmpleadoREST();
		return emp.getEmpleado();
	}

}
