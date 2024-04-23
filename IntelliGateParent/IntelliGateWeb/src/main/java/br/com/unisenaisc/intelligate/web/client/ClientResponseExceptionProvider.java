package br.com.unisenaisc.intelligate.web.client;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.ext.Provider;

import br.com.unisenaisc.intelligate.api.common.dto.ExceptionDTO;
import br.com.unisenaisc.intelligate.api.common.json.ObjectMapperFactory;
import br.com.unisenaisc.intelligate.exception.BusinessException;

@Provider
public class ClientResponseExceptionProvider implements ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		int statusCode = responseContext.getStatus();
		Family familyResponse = Status.Family.familyOf(statusCode);
		
		boolean isBadRequest = Status.BAD_REQUEST.getStatusCode() == statusCode;
		boolean isClientError = familyResponse.equals(Family.CLIENT_ERROR);
		boolean isServerError = familyResponse.equals(Family.SERVER_ERROR);
		
		
		if(isBadRequest) {
			ExceptionDTO exception = getExceptionDto(responseContext);
			throw new BusinessException(exception.getMessage());
		}
		
		if(isServerError || isClientError) {
			String formatedMessageException = getFormatedMessageException(responseContext);
			throw new BusinessException(formatedMessageException);
		}
		
	}

	private ExceptionDTO getExceptionDto(ClientResponseContext responseContext) {
		if(responseContext.hasEntity()) {
			return convertResponseToExceptionDto(responseContext);
		} else {
			String formatedMessageException = getFormatedMessageException(responseContext);
			throw new BusinessException(formatedMessageException);
		}
	}

	private ExceptionDTO convertResponseToExceptionDto(ClientResponseContext responseContext) {
		try {
			InputStream entityStream = responseContext.getEntityStream();
			ExceptionDTO exception = ObjectMapperFactory.getObjectMapper().readValue(entityStream, ExceptionDTO.class);
			return exception;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	private String getFormatedMessageException(ClientResponseContext responseContext) {
		int statusCode = responseContext.getStatus();
		Status status = Status.fromStatusCode(statusCode);
		return new StringBuilder()
						.append("Ocorreu um erro na requisição: ")
						.append(statusCode)
						.append(" - ")
						.append(status.getReasonPhrase()).toString();
	}
	
}