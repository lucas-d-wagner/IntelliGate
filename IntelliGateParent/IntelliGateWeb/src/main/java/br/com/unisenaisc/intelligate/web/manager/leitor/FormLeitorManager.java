package br.com.unisenaisc.intelligate.web.manager.leitor;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.LeitorDTO;
import br.com.unisenaisc.intelligate.common.api.resource.LeitorResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class FormLeitorManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private LeitorDTO leitor;
	
	private boolean editing = false;
	
	@PostConstruct
	public void init() {
		Long idLeitor = (Long) getExternalContext().getFlash().get("idLeitor");
		
		if(idLeitor == null) {
			this.leitor = new LeitorDTO();
			this.editing = false;
		} else {
			this.leitor = getResource().find(idLeitor);
			this.editing = true;
		}
	}
	
	public void salvar() {
		try {
			if(editing) {
				getResource().update(this.leitor.getIdLeitor(), leitor);
			} else {
				getResource().insert(this.leitor);
			}
				
			addFacesMessage("Registro salvo com sucesso.");
			
			getExternalContext().getFlash().setKeepMessages(true);
			
			redirectTo("listagemLeitor.xhtml");
			
		} catch(Exception e) {
			addFacesMessage(e);
		}
	}

	private LeitorResource getResource() {
		return getResource(LeitorResource.class);
	}

	public LeitorDTO getLeitor() {
		return leitor;
	}

	public void setLeitor(LeitorDTO leitor) {
		this.leitor = leitor;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}
	
}
