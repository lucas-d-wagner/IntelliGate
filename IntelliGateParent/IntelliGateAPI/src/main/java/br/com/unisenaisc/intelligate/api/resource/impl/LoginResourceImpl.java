package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.common.dto.LoginDTO;
import br.com.unisenaisc.intelligate.api.common.dto.TokenDTO;
import br.com.unisenaisc.intelligate.api.common.resource.LoginResource;
import br.com.unisenaisc.intelligate.api.jwt.JWT;
import br.com.unisenaisc.intelligate.api.resource.AbstractResource;
import br.com.unisenaisc.intelligate.context.LoginContext;
import br.com.unisenaisc.intelligate.exception.BusinessCheckedException;
import br.com.unisenaisc.intelligate.service.LoginService;

@ManagedBean
@Transactional
public class LoginResourceImpl extends AbstractResource implements LoginResource {

	@Override
	public TokenDTO login(LoginDTO dto) throws BusinessCheckedException {
		String login = dto.getLogin();
		String password = dto.getPassword();
		
		LoginService loginService = new LoginService();
		
		LoginContext loginContext = loginService.login(login, password);
		
		return JWT.buildTokenDTO(loginContext);
	}

}
