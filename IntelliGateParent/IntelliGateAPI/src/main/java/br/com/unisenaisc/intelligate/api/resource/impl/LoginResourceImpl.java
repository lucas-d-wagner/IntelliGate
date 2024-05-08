package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.jwt.JWT;
import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.business.service.LoginService;
import br.com.unisenaisc.intelligate.common.api.dto.LoginDTO;
import br.com.unisenaisc.intelligate.common.api.dto.TokenDTO;
import br.com.unisenaisc.intelligate.common.api.resource.LoginResource;
import br.com.unisenaisc.intelligate.common.context.LoginContext;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

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
