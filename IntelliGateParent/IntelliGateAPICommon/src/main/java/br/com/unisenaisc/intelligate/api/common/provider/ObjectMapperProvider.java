package br.com.unisenaisc.intelligate.api.common.provider;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unisenaisc.intelligate.api.common.json.ObjectMapperFactory;

public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return ObjectMapperFactory.getObjectMapper();
	}

}
