package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.model.entity.Usuario;

public class UsuarioConverter extends AbstractDTOConverter<Usuario, UsuarioDTO> {

	@Override
	public UsuarioDTO convertToDTO(Usuario entity) {
		if(entity == null) {
			return null;
		}
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setIdUsuario(entity.getIdUsuario());
		dto.setNome(entity.getNome());
		dto.setAdministrador(entity.isAdministrador());
		dto.setLogin(entity.getLogin());
		//NÃO PASSAR A SENHA NO DTO!
		
		return dto;
	}

	@Override
	public Usuario convertToEntity(UsuarioDTO dto) {
		if(dto == null) {
			return null;
		}

		Usuario entity = new Usuario();
		
		entity.setIdUsuario(dto.getIdUsuario());
		entity.setNome(dto.getNome());
		entity.setAdministrador(dto.isAdministrador());
		entity.setLogin(dto.getLogin());
		entity.setSenha(dto.getSenha());
		
		return entity;
	}

}
