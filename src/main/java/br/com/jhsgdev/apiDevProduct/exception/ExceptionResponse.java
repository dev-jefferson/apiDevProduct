package br.com.jhsgdev.apiDevProduct.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String details;

}
