package br.com.unisenaisc.intelligate.web.manager;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.unisenaisc.intelligate.common.util.ExceptionUtil;
import br.com.unisenaisc.intelligate.web.client.ClientRestProxyService;


public abstract class AbstractFormManager implements Serializable {

	private static final long serialVersionUID = 1L;

	public void addFacesMessage(Exception exception) {
		String message = ExceptionUtil.getMessage(exception);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
		getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public void addFacesMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
		getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public void redirectTo(String path) {
		try {
			getExternalContext().redirect(path);
		} catch (IOException e) {
			addFacesMessage(e);
		}
	}
	
	public FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}
	
	public ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public HttpSession getHttpSession() {
		return (HttpSession) getExternalContext().getSession(true);
	}
	
	public <T> T getResource(Class<T> resourceInterface) {
		return new ClientRestProxyService().createProxy(resourceInterface);
	}
	
}
