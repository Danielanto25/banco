package com.neorispichincha.app.excepcion;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request) {

		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		System.out.println(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String mensaje = ex.getBindingResult().getAllErrors().stream().map(e -> {
			return e.getDefaultMessage().toString().concat(", ");
		}).collect(Collectors.joining());

		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), mensaje, request.getDescription(false));

		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoEncontradoException.class)
	public ResponseEntity<ExceptionResponse> manejarModeloNotFoundException(NoEncontradoException ex,
																			WebRequest request) {

		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RepetidoModelException.class)
	public ResponseEntity<ExceptionResponse> manejarRepetidoModeloNotFoundException(RepetidoModelException ex,
			WebRequest request) {

		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ExcepcionTipoDeCuenta.class)
	public ResponseEntity<ExceptionResponse> manejarTipoDeCuentaInvalida(ExcepcionTipoDeCuenta ex,
																					WebRequest request) {

		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ExcepcionMovimientoNoValido.class)
	public ResponseEntity<ExceptionResponse> manejarMovimientoNoValido(ExcepcionMovimientoNoValido ex,
																		 WebRequest request) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ExcepcionArgumento.class)
	public ResponseEntity<ExceptionResponse> manejarArgumento(ExcepcionArgumento ex,
																	   WebRequest request) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}

}
