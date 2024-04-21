package br.com.unisenaisc.intelligate.service;

import br.com.unisenaisc.intelligate.context.LoginContext;
import br.com.unisenaisc.intelligate.exception.BusinessCheckedException;

public class LoginService {
	
	public LoginContext login(String login, String password) throws BusinessCheckedException {
		if(login.equals("admin") && password.equals("admin")) {
			return new LoginContext(1L, login, true);
		}
		
		throw new BusinessCheckedException("Usuario ou senha inválidos, verifique os campos e tente novamente.");
	}

}
