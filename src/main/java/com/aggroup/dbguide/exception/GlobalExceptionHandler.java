package com.aggroup.dbguide.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aggroup.dbguide.ResponseStatus;
import com.aggroup.dbguide.dto.AppResponseDto;

/**
 * This class responsible on handling the global exception in the application
 * 
 * @author Mina
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * When validation on mandatory constrains fire, this handler will return the parameter names which need to be handled based on the constrains
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity <AppResponseDto<Object>> onUnexpectedException(MethodArgumentNotValidException exception) {
		Map<String, String> response = new HashMap<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			response.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ResponseEntity<>(
				new AppResponseDto<>(ResponseStatus.BAD_REQUEST.value(), ResponseStatus.BAD_REQUEST.name(), response), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	ResponseEntity <AppResponseDto<Object>> onNotFoundException() {
		return new ResponseEntity<>(
				new AppResponseDto<>(ResponseStatus.NOT_FOUND.value(), ResponseStatus.NOT_FOUND.name()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity <AppResponseDto<Object>> onOtherException(Exception exception) {
		return new ResponseEntity<>(
				new AppResponseDto<>(ResponseStatus.SERVER_ERROR.value(), ResponseStatus.SERVER_ERROR.name(), exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	
}
