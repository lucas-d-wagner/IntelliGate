package br.com.unisenaisc.intelligate.web.manager.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaVeiculoResource;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class PessoaVeiculoManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;
	
	private FormPessoaManager parentManager; 
	
	private PessoaVeiculoDTO pessoaVeiculo = new PessoaVeiculoDTO();

	private List<PessoaVeiculoDTO> pessoaVeiculos = new ArrayList<>();
	
	private List<VeiculoDTO> veiculos = new ArrayList<>();

	private Long idExclusao;
	
	public PessoaVeiculoManager(FormPessoaManager parentManager) {
		this.parentManager = parentManager;
	}
	
	public void inicializarAba() {
		Long idPessoa = getIdPessoa();
		
		if(idPessoa == null) {
			pessoaVeiculo = new PessoaVeiculoDTO();
			pessoaVeiculos = new ArrayList<>();
			veiculos = new ArrayList<>();
		} else {
			consultarVeiculos();
			consultarVeiculosPessoa();
		}
	}
	
	public void consultarVeiculosPessoa() {
		this.pessoaVeiculos = new ArrayList<>(getResource().findAll(getIdPessoa()));
	}
	
	public void consultarVeiculos() {
		this.veiculos = new ArrayList<>(getVeiculoResource().findAll());
	}

	public void excluir() {
		try {
			getResource().delete(getIdPessoa(), idExclusao);
			
			addFacesMessage("Veículo desvinculado com sucesso.");
			
			consultarVeiculosPessoa();

		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
	public void vincularVeiculo() {
		try {
			getResource().insert(getIdPessoa(), pessoaVeiculo);
			
			addFacesMessage("Veículo vinculado com sucesso.");
			
			consultarVeiculosPessoa();

		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
	public void redirecionarCadastroVeiculo() {
		redirectTo("/IntelliGateWeb/intelligate/veiculo/formVeiculo.xhtml");
	}
	
	private Long getIdPessoa() {
		return parentManager.getPessoa() != null ? parentManager.getPessoa().getIdPessoa() : null;
	}

	private PessoaVeiculoResource getResource() {
		return getResource(PessoaVeiculoResource.class);
	}

	private VeiculoResource getVeiculoResource() {
		return getResource(VeiculoResource.class);
	}
	
	public FormPessoaManager getParentManager() {
		return parentManager;
	}

	public void setParentManager(FormPessoaManager parentManager) {
		this.parentManager = parentManager;
	}

	public PessoaVeiculoDTO getPessoaVeiculo() {
		return pessoaVeiculo;
	}

	public void setPessoaVeiculo(PessoaVeiculoDTO pessoaVeiculo) {
		this.pessoaVeiculo = pessoaVeiculo;
	}

	public List<PessoaVeiculoDTO> getPessoaVeiculos() {
		return pessoaVeiculos;
	}

	public void setPessoaVeiculos(List<PessoaVeiculoDTO> pessoaVeiculos) {
		this.pessoaVeiculos = pessoaVeiculos;
	}

	public Long getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(Long idExclusao) {
		this.idExclusao = idExclusao;
	}

	public List<VeiculoDTO> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoDTO> veiculos) {
		this.veiculos = veiculos;
	}
	
}
