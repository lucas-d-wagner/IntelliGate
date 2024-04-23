package br.com.unisenaisc.intelligate.web;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.api.common.dto.LoginDTO;
import br.com.unisenaisc.intelligate.api.common.dto.TokenDTO;
import br.com.unisenaisc.intelligate.api.common.resource.LoginResource;

@Named
@RequestScoped
public class LoginManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	
	public void login() throws Exception {
		try {
			LoginDTO dto = new LoginDTO(login, password);
			TokenDTO token = getLoginResource().login(dto);
			criarSessaoLoginUsuario(token);
		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
	public void logout() throws IOException {
		getExternalContext().getSessionMap().remove("token");
		getExternalContext().redirect("login.xhtml");
	}
	
	private void criarSessaoLoginUsuario(TokenDTO token) throws Exception {
		getExternalContext().getSessionMap().put("token", token.getToken());
		getExternalContext().redirect("index.xhtml");
	}
	
	public LoginResource getLoginResource() {
		return getResource(LoginResource.class);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
