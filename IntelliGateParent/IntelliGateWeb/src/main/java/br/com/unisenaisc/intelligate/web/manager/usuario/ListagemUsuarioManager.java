package br.com.unisenaisc.intelligate.web.manager.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.common.api.resource.UsuarioResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class ListagemUsuarioManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private List<UsuarioDTO> usuarios = new ArrayList<>();
	
	private Long idExclusao;
	
	@PostConstruct
	public void init() {
		consultar();
	}
	
	private void consultar() {
		this.usuarios = new ArrayList<>(getResource().findAll());
	}

	public void editar(UsuarioDTO usuario) {
		getExternalContext().getFlash().put("idUsuario", usuario.getIdUsuario());
		redirectTo("formUsuario.xhtml");
	}
	
	public void excluir() {
		try {
			getResource().delete(idExclusao);
			
			addFacesMessage("Registro excluído com sucesso.");
			
			consultar();

		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
	private UsuarioResource getResource() {
		return getResource(UsuarioResource.class);
	}

	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}

	public Long getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(Long idExclusao) {
		this.idExclusao = idExclusao;
	}
	
}
