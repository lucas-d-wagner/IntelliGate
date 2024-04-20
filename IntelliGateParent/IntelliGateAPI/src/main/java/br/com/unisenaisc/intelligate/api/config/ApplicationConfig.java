package br.com.unisenaisc.intelligate.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.unisenaisc.intelligate.api.resource.impl.UsuarioResourceImpl;

@ApplicationPath("v1")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> listaResources = new HashSet<>();
		
		listaResources.add(UsuarioResourceImpl.class);
		
		return listaResources;
	}
	
}
