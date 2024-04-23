package br.com.unisenaisc.intelligate.util;

import java.util.Objects;

public class ExceptionUtil {

	public static String getMessage(Exception exception) {
		String message = exception.getMessage();
		Throwable cause = exception.getCause();
		if (Objects.isNull(message) && Objects.nonNull(cause)) {
			message = cause.getMessage();
		}
		if (Objects.isNull(message)) {
			message = exception.toString();
		}
		return message;
	}
	
}
