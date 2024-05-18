package br.com.unisenaisc.intelligate.web.manager.veiculo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class ListagemVeiculoManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private List<VeiculoDTO> veiculos = new ArrayList<>();
	
	private Long idExclusao;
	
	@PostConstruct
	public void init() {
		consultar();
	}
	
	private void consultar() {
		this.veiculos = new ArrayList<VeiculoDTO>(getResource().findAll());
	}

	public void editar(VeiculoDTO veiculo) {
		getExternalContext().getFlash().put("idVeiculo", veiculo.getIdVeiculo());
		redirectTo("formVeiculo.xhtml");
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
	
	private VeiculoResource getResource() {
		return getResource(VeiculoResource.class);
	}
	
	public List<VeiculoDTO> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoDTO> veiculos) {
		this.veiculos = veiculos;
	}

	public Long getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(Long idExclusao) {
		this.idExclusao = idExclusao;
	}

}
