package com.sss.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.sss.entitys.Epp;

public class CSV {

	public static String TYPE = "text/csv";
	
	static String[] HEADERs = { "idEpp", "nombreEpp", "referencia", "especificaciones", "caracteristicas", "proveedor",
			"peligroCubre", "parteProtege", "eppCargoId" };

	 public static boolean hasCSVFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }

		  public static List<Epp> csvEpp(InputStream is) {
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

		      List<Epp> epps = new ArrayList<Epp>();

		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		      for (CSVRecord csvRecord : csvRecords) {
		        Epp epp = new Epp(
		              Long.parseLong(csvRecord.get("idEpp")),
		              csvRecord.get("nombreEpp"),
		              csvRecord.get("referencia"),
		              csvRecord.get("especificaciones"),
		              csvRecord.get("caracteristicas"),
		              csvRecord.get("proveedor"),
		              csvRecord.get("peligroCubre"),
		              csvRecord.get("parteProtege"),
		              Long.parseLong(csvRecord.get("eppCargoId"))
		            );

		        epps.add(epp);
		      }

		      return epps;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }

}
