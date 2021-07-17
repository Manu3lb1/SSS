package com.sss.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sss.dao.EppDAO;
import com.sss.dto.CtrabajoEppDTO;
import com.sss.entitys.Epp;

public class CSV {
	
	public final static String TYPE = "text/csv";
	public final static char SEPARADOR = '|';

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public List<Epp> csvEpp(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {

			CsvToBean<CtrabajoEppDTO> ctb = new CsvToBeanBuilder<CtrabajoEppDTO>(fileReader)
					.withType(CtrabajoEppDTO.class).withSeparator(SEPARADOR).build();

			List<CtrabajoEppDTO> dtoList = ctb.parse();
			List<Epp> eppReturn = new ArrayList<>();
			for (CtrabajoEppDTO dto : dtoList) {
				
				Epp epp = new Epp();
				epp.setNombreEpp(dto.getNombreEpp());
				epp.setReferencia(dto.getReferencia());
				epp.setEspecificaciones(dto.getEspecificaciones());
				epp.setCaracteristicas(dto.getCaracteristicas());
				epp.setProveedor(dto.getProveedor());
				epp.setPeligroCubre(dto.getPeligroCubre());
				epp.setParteProtege(dto.getParteProtege());
				
				eppReturn.add(epp);
			}

			return eppReturn;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	public MultipartFile csvGetFile(EppDAO eppDao) {
		
		List<Epp> eppList = eppDao.findAll();
		List<CtrabajoEppDTO> dtoList = new ArrayList<>();
		for (Epp epp : eppList) {
			
			CtrabajoEppDTO dto = new CtrabajoEppDTO();
			dto.setNombreEpp(epp.getNombreEpp());
			dto.setReferencia(epp.getReferencia());
			dto.setEspecificaciones(epp.getEspecificaciones());
			dto.setCaracteristicas(epp.getCaracteristicas());
			dto.setProveedor(epp.getProveedor());
			dto.setPeligroCubre(epp.getPeligroCubre());
			dto.setParteProtege(epp.getParteProtege());
			
			
			// hacer esto
			
			dtoList.add(dto);
		}
		
		
		try {
			URI uri = new URI("file:///src/main/resources/prueba.csv");
			Writer writer = Files.newBufferedWriter(Paths.get(uri));
			
			
			StatefulBeanToCsv<CtrabajoEppDTO> bst = 
					new StatefulBeanToCsvBuilder<CtrabajoEppDTO>(writer)
					.withQuotechar(SEPARADOR)
					.build();
			
			bst.write(dtoList);
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
}





