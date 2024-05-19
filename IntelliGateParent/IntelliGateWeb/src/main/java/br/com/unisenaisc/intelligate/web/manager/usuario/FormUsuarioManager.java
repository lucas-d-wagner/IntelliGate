package br.com.unisenaisc.intelligate.web.manager.usuario;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.common.api.resource.UsuarioResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class FormUsuarioManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuario;
	
	private boolean editing = false;
	
	@PostConstruct
	public void init() {
		Long idUsuario = (Long) getExternalContext().getFlash().get("idUsuario");
		
		if(idUsuario == null) {
			this.usuario = new UsuarioDTO();
			this.editing = false;
		} else {
			this.usuario = getResource().find(idUsuario);
			this.editing = true;
		}
	}
	
	public void salvar() {
		try {
			if(editing) {
				getResource().update(this.usuario.getIdUsuario(), usuario);
			} else {
				getResource().insert(this.usuario);
			}
				
			addFacesMessage("Registro salvo com sucesso.");
			
			getExternalContext().getFlash().setKeepMessages(true);
			
			redirectTo("listagemUsuario.xhtml");
			
		} catch(Exception e) {
			addFacesMessage(e);
		}
	}

	private UsuarioResource getResource() {
		return getResource(UsuarioResource.class);
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}
	
}
