package com.ms_alumnos.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ms_alumnos.request.ApiErrores;

@ControllerAdvice
public class GoblalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("Verbo Http No Soportado Por la petición. Verifique el uso del verbo correcto");
		ApiErrores error = new ApiErrores(mensaje, detalles, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			String mensaje = ex.getMessage();
	List<String> detalles = new ArrayList<String>();
	detalles.add("MediaType Incorrecto. Utilice MediaType JSON");
	ApiErrores error = new ApiErrores(mensaje, detalles, status,LocalDateTime.now());
	return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("No ha enviado la información en el body/formulario");
		ApiErrores error = new ApiErrores(mensaje, detalles, status,LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
		
	}
	
	// Creamos un método propio que responda con un msj diferente y estatus ante la excepción 
	// que nosotros creamos
	
	public ResponseEntity<Object>handleNoSePuedeEditarException(NoSePuedeEditarException ex){
		String mensaje = ex.getMessage();
		List<String> detalles = new ArrayList<String>();
		detalles.add("No se puede editar/actualizar a un alumno dado de baja. Status = 0");
		ApiErrores error = new ApiErrores(mensaje, detalles, HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}