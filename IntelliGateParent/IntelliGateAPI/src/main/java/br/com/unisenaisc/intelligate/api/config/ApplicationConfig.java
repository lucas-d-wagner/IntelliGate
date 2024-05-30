package br.com.unisenaisc.intelligate.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.reflections.Reflections;

import br.com.unisenaisc.intelligate.api.provider.AuthenticationFilterProvider;
import br.com.unisenaisc.intelligate.api.provider.ExceptionMapperProvider;
import br.com.unisenaisc.intelligate.api.provider.ValidateClientAddressFilterProvider;
import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.common.api.provider.ObjectMapperProvider;

@ApplicationPath("v1")
public class ApplicationConfig extends Application {

	private static final String RESOURCES_PACKAGE = "br.com.unisenaisc.intelligate.api.resource.impl";
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		loadResourcesClass(resources, RESOURCES_PACKAGE);
		loadProvidersClass(resources);
		return resources;
	}
	
	private void loadResourcesClass(Set<Class<?>> resourcesClass, String packageName) {
		Set<Class<? extends AbstractResource>> resources = new Reflections(packageName).getSubTypesOf(AbstractResource.class);
		resourcesClass.addAll(resources);
	}
	
	private void loadProvidersClass(Set<Class<?>> resourcesClass) {
		resourcesClass.add(ObjectMapperProvider.class);
		resourcesClass.add(ExceptionMapperProvider.class);
		resourcesClass.add(AuthenticationFilterProvider.class);
		resourcesClass.add(ValidateClientAddressFilterProvider.class);
	}

}
