package com.sss.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sss.controller.EmpleadoController;
import com.sss.entitys.Empleado;
import com.sss.service.ServiceEmpleado;

public class ServiceEmpleadoImpl implements ServiceEmpleado{

	@Override
	public ResponseEntity<List<Empleado>> listAllEmpleado() {
		EmpleadoController emp = new EmpleadoController();
		return emp.getEmpleado();
	}

}
