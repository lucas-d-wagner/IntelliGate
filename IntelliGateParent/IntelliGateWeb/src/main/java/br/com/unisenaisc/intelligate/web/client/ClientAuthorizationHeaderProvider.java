package br.com.unisenaisc.intelligate.web.client;

import java.io.IOException;
import java.util.Objects;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String token = Objects.toString(httpSession.getAttribute("token"), "");
		return new StringBuilder().append("Bearer ").append(token).toString();
	}
	
}
