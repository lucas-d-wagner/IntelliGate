package br.com.unisenaisc.intelligate.web.manager.veiculo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoIdentificacaoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoIdentificacaoResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class VeiculoIdentificaoManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private FormVeiculoManager parentManager; 
	
	private VeiculoIdentificacaoDTO veiculoIdentificacao = new VeiculoIdentificacaoDTO();

	private List<VeiculoIdentificacaoDTO> veiculoIdentificacoes = new ArrayList<>();
	
	private Long idExclusao;

	public VeiculoIdentificaoManager(FormVeiculoManager parentManager) {
		this.parentManager = parentManager;
	}
	
	public void inicializarAba() {
		Long idVeiculo = getIdVeiculo();
		
		if(idVeiculo == null) {
			veiculoIdentificacao = new VeiculoIdentificacaoDTO();
			veiculoIdentificacoes = new ArrayList<>();
		} else {
			consultarIdentificacoesVeiculo();
		}
	}
	
	public void consultarIdentificacoesVeiculo() {
		this.veiculoIdentificacoes = new ArrayList<>(getResource().findAll(getIdVeiculo()));
	}
	
	public void excluir() {
		try {
			getResource().delete(getIdVeiculo(), idExclusao);
			
			addFacesMessage("Identificação removida com sucesso.");
			
			consultarIdentificacoesVeiculo();

		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
	public void adicionarIdentificacao() {
		try {
			getResource().insert(getIdVeiculo(), veiculoIdentificacao);
			
			addFacesMessage("Identificação adicionada com sucesso.");
			
			consultarIdentificacoesVeiculo();

		} catch (Exception e) {
			addFacesMessage(e);
		}
	}

	private Long getIdVeiculo() {
		return parentManager.getVeiculo() != null ? parentManager.getVeiculo().getIdVeiculo() : null;
	}

	private VeiculoIdentificacaoResource getResource() {
		return getResource(VeiculoIdentificacaoResource.class);
	}

	public FormVeiculoManager getParentManager() {
		return parentManager;
	}

	public void setParentManager(FormVeiculoManager parentManager) {
		this.parentManager = parentManager;
	}

	public VeiculoIdentificacaoDTO getVeiculoIdentificacao() {
		return veiculoIdentificacao;
	}

	public void setVeiculoIdentificacao(VeiculoIdentificacaoDTO veiculoIdentificacao) {
		this.veiculoIdentificacao = veiculoIdentificacao;
	}

	public List<VeiculoIdentificacaoDTO> getVeiculoIdentificacoes() {
		return veiculoIdentificacoes;
	}

	public void setVeiculoIdentificacoes(List<VeiculoIdentificacaoDTO> veiculoIdentificacoes) {
		this.veiculoIdentificacoes = veiculoIdentificacoes;
	}

	public Long getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(Long idExclusao) {
		this.idExclusao = idExclusao;
	}

}
