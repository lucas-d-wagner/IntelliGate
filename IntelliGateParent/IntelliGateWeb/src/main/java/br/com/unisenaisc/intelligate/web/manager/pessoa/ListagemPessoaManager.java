package br.com.unisenaisc.intelligate.web.manager.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class ListagemPessoaManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private List<PessoaDTO> pessoas = new ArrayList<>();
	
	private Long idExclusao;
	
	@PostConstruct
	public void init() {
		consultar();
	}
	
	private void consultar() {
		this.pessoas = new ArrayList<PessoaDTO>(getResource().findAll());
	}

	public void editar(PessoaDTO pessoa ) {
		getExternalContext().getFlash().put("idPessoa", pessoa.getIdPessoa());
		redirectTo("formPessoa.xhtml");
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
	
	private PessoaResource getResource() {
		return getResource(PessoaResource.class);
	}
	
	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaDTO> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Long getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(Long idExclusao) {
		this.idExclusao = idExclusao;
	}

}
