package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.business.repository.UsuarioRepository;
import br.com.unisenaisc.intelligate.common.context.LoginContext;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;
import br.com.unisenaisc.intelligate.model.entity.Usuario;

@ManagedBean
public class LoginService {
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	public LoginContext login(String login, String password) throws BusinessCheckedException {
		Usuario usuario = usuarioRepository.findByLogin(login);

		if(usuario == null) {
			throw new BusinessCheckedException("Usuario inválido, verifique os campos e tente novamente.");
		}
		
		if(usuario.getSenha().equals(password) == false) {
			throw new BusinessCheckedException("Senha inválida, verifique os campos e tente novamente.");
		}
		
		return new LoginContext(usuario.getIdUsuario(), usuario.getLogin(), usuario.isAdministrador());
	}

}
