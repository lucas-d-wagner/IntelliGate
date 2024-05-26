package br.com.unisenaisc.intelligate.web.manager.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaDTO;
import br.com.unisenaisc.intelligate.common.api.dto.TipoPessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaResource;
import br.com.unisenaisc.intelligate.common.api.resource.TipoPessoaResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class FormPessoaManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;
	
	private PessoaVeiculoManager pessoaVeiculoManager;

	private PessoaDTO pessoa;
	
	private List<TipoPessoaDTO> tiposPessoa = new ArrayList<>();
	
	private boolean editing = false;
	
	public FormPessoaManager() {
		this.pessoaVeiculoManager = new PessoaVeiculoManager(this);
	}

	@PostConstruct
	public void init() {
		Long idPessoa = (Long) getExternalContext().getFlash().get("idPessoa");
		
		if(idPessoa == null) {
			this.pessoa = new PessoaDTO();
			this.editing = false;
		} else {
			this.pessoa = getResource().find(idPessoa);
			this.editing = true;
		}
		
		this.tiposPessoa = new ArrayList<>(getTipoPessoaResource().findAll());
		
		this.pessoaVeiculoManager.inicializarAba();
	}
	
	public void salvar() {
		try {
			if(editing) {
				getResource().update(this.pessoa.getIdPessoa(), pessoa);
			} else {
				getResource().insert(this.pessoa);
			}
				
			addFacesMessage("Registro salvo com sucesso.");
			
			getExternalContext().getFlash().setKeepMessages(true);
			
			redirectTo("listagemPessoa.xhtml");
			
		} catch(Exception e) {
			addFacesMessage(e);
		}
	}
	
	private TipoPessoaResource getTipoPessoaResource() {
		return getResource(TipoPessoaResource.class);
	}
	
	private PessoaResource getResource() {
		return getResource(PessoaResource.class);
	}
	
	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}

	public List<TipoPessoaDTO> getTiposPessoa() {
		return tiposPessoa;
	}

	public void setTiposPessoa(List<TipoPessoaDTO> tiposPessoa) {
		this.tiposPessoa = tiposPessoa;
	}
	
	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public PessoaVeiculoManager getPessoaVeiculoManager() {
		return pessoaVeiculoManager;
	}

	public void setPessoaVeiculoManager(PessoaVeiculoManager pessoaVeiculoManager) {
		this.pessoaVeiculoManager = pessoaVeiculoManager;
	}
	
}
