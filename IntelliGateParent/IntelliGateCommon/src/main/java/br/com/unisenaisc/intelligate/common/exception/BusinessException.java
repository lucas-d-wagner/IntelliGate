package br.com.unisenaisc.intelligate.common.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException() { }

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
	
}
