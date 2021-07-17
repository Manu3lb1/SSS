package com.sss.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.sss.csv.CSV;
import com.sss.dao.EppDAO;
import com.sss.entitys.Epp;

@Service
public class CargarServicio {
	
	@Autowired
	EppDAO eppDao;

	public void save(MultipartFile file) {
		try {
			List<Epp> epps = new CSV().csvEpp(file.getInputStream());
			eppDao.saveAll(epps);
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}
	
	
	public MultipartFile getFile() {
		return new CSV().csvGetFile(eppDao);
	}

}
