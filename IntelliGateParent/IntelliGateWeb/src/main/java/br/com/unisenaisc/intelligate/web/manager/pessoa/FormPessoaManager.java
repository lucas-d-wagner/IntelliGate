package br.com.unisenaisc.intelligate.web.manager.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaDTO;
import br.com.unisenaisc.intelligate.common.api.dto.PessoaVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.dto.TipoPessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaResource;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaVeiculoResource;
import br.com.unisenaisc.intelligate.common.api.resource.TipoPessoaResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class FormPessoaManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private PessoaDTO pessoa;
	
	private List<TipoPessoaDTO> tiposPessoa = new ArrayList<>();
	
	private List<PessoaVeiculoDTO> pessoaVeiculos = new ArrayList<>();

	private boolean editing = false;
	
	private Long idExclusaoPessoaVeiculo;
	
	private String placa;
	
	@PostConstruct
	public void initi() {
		Long idPessoa = (Long) getExternalContext().getFlash().get("idPessoa");
		
		if(idPessoa == null) {
			this.pessoa = new PessoaDTO();
			this.editing = false;
			this.pessoaVeiculos = new ArrayList<>();
		} else {
			this.pessoa = getResource().find(idPessoa);
			this.editing = true;
			consultarVeiculos();
		}
		
		this.tiposPessoa = new ArrayList<>(getTipoPessoaResource().findAll());
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
	
	private void consultarVeiculos() {
		this.pessoaVeiculos = new ArrayList<>(getPessoaVeiculoResource().findAll(this.pessoa.getIdPessoa()));
	}
	
	public void excluirPessoaVeiculo() {
		try {
			getPessoaVeiculoResource().delete(this.pessoa.getIdPessoa(), idExclusaoPessoaVeiculo);
			
			addFacesMessage("Veículo desvinculado com sucesso.");
			
			consultarVeiculos();

		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
	public void vincularVeiculo() {
		
		System.out.println("TESTE");
		
	}

	private TipoPessoaResource getTipoPessoaResource() {
		return getResource(TipoPessoaResource.class);
	}
	
	private PessoaVeiculoResource getPessoaVeiculoResource() {
		return getResource(PessoaVeiculoResource.class);
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
	
	public List<PessoaVeiculoDTO> getPessoaVeiculos() {
		return pessoaVeiculos;
	}

	public void setPessoaVeiculos(List<PessoaVeiculoDTO> pessoaVeiculos) {
		this.pessoaVeiculos = pessoaVeiculos;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public Long getIdExclusaoPessoaVeiculo() {
		return idExclusaoPessoaVeiculo;
	}

	public void setIdExclusaoPessoaVeiculo(Long idExclusaoPessoaVeiculo) {
		this.idExclusaoPessoaVeiculo = idExclusaoPessoaVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
