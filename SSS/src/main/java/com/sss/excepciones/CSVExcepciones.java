package com.sss.excepciones;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sss.mensaje.EppMensaje;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CSVExcepciones extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new EppMensaje("File too large!"));
	  }

}
