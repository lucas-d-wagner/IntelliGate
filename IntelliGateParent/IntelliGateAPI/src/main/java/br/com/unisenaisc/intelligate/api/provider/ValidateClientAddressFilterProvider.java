package br.com.unisenaisc.intelligate.api.provider;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.ManagedBean;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import br.com.unisenaisc.intelligate.api.cache.ValidClientAddressCache;
import br.com.unisenaisc.intelligate.common.api.annotation.ValidateClientAddress;

@Provider
@ManagedBean
@Priority(Priorities.AUTHENTICATION)
public class ValidateClientAddressFilterProvider implements ContainerRequestFilter {

    @Context
    private HttpServletRequest request;
	
	@Context
	private ResourceInfo resourceInfo;
	
	@Inject
	private ValidClientAddressCache validClientAddressCache;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(shouldValidateAddress()) validateClientAddress();;
	}

	private void validateClientAddress() {
		String clientAddress = request.getRemoteAddr();
		if(invalidAddress(clientAddress)) {
			throw new NotAuthorizedException(Response.status(Status.UNAUTHORIZED));
		}
	}

	private boolean invalidAddress(String clientAddress) {
		return validClientAddressCache.isValidAddress(clientAddress) == false;
	}
	
	private boolean shouldValidateAddress() {
		Method resourceMethod = resourceInfo.getResourceMethod();
		return resourceMethod.isAnnotationPresent(ValidateClientAddress.class);
	}

}
