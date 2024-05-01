package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.api.common.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.common.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.model.Usuario;

public class UsuarioConverter extends AbstractDTOConverter<Usuario, UsuarioDTO> {

	@Override
	public UsuarioDTO convertToDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setIdUsuario(entity.getIdUsuario());
		dto.setNome(entity.getNome());
		dto.setLogin(entity.getLogin());
		//NÃO PASSAR A SENHA NO DTO!
		
		return dto;
	}

	@Override
	public Usuario convertToEntity(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		
		entity.setIdUsuario(dto.getIdUsuario());
		entity.setNome(dto.getNome());
		entity.setLogin(dto.getLogin());
		entity.setSenha(dto.getSenha());
		
		return entity;
	}

}
