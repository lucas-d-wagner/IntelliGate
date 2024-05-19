package br.com.unisenaisc.intelligate.web.manager.leitor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.LeitorDTO;
import br.com.unisenaisc.intelligate.common.api.resource.LeitorResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class ListagemLeitorManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private List<LeitorDTO> leitores = new ArrayList<>();
	
	private Long idExclusao;
	
	@PostConstruct
	public void init() {
		consultar();
	}
	
	private void consultar() {
		this.leitores = new ArrayList<>(getResource().findAll());
	}

	public void editar(LeitorDTO leitor) {
		getExternalContext().getFlash().put("idLeitor", leitor.getIdLeitor());
		redirectTo("formLeitor.xhtml");
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
	
	private LeitorResource getResource() {
		return getResource(LeitorResource.class);
	}

	public List<LeitorDTO> getLeitores() {
		return leitores;
	}

	public void setLeitores(List<LeitorDTO> leitores) {
		this.leitores = leitores;
	}

	public Long getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(Long idExclusao) {
		this.idExclusao = idExclusao;
	}

}
