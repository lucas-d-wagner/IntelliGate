package br.com.unisenaisc.intelligate.web.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ClientRestProxyService {

	private final String URI_API = "http://localhost:8080/IntelliGateAPI/v1";
	
	public <T> T createProxy(Class<T> resourceInterface) {
		Client client = ClientBuilder.newClient();
		client.register(ClientAuthorizationHeaderProvider.class);
		client.register(ClientResponseExceptionProvider.class);
		WebTarget target = client.target(URI_API);
		ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget) target;
		return resteasyWebTarget.proxy(resourceInterface);
	}
	
}
