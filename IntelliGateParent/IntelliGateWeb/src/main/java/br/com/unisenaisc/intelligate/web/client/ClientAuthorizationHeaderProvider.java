package br.com.unisenaisc.intelligate.web.client;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientAuthorizationHeaderProvider implements ClientRequestFilter {
	
	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, getToken());
		
	}

	private String getToken() {
		String token = (String) FacesContext
									.getCurrentInstance()
									.getExternalContext()
									.getSessionMap()
									.get("token");
		return new StringBuilder().append("Bearer ").append(token).toString();
	}
}
