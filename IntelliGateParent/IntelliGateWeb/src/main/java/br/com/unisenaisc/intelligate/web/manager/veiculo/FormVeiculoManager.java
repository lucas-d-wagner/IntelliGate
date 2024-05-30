package br.com.unisenaisc.intelligate.web.manager.veiculo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.unisenaisc.intelligate.common.api.dto.TipoVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoVeiculoResource;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@ViewScoped
public class FormVeiculoManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;
	
	private VeiculoIdentificaoManager veiculoIdentificaoManager;

	private VeiculoDTO veiculo;
	
	private List<TipoVeiculoDTO> tiposVeiculo = new ArrayList<>();

	private boolean editing = false;
	
	public FormVeiculoManager() {
		this.veiculoIdentificaoManager = new VeiculoIdentificaoManager(this);
	}
	
	@PostConstruct
	public void init() {
		Long idVeiculo = (Long) getExternalContext().getFlash().get("idVeiculo");
		
		if(idVeiculo == null) {
			this.veiculo = new VeiculoDTO();
			this.editing = false;
		} else {
			this.veiculo = getResource().find(idVeiculo);
			this.editing = true;
		}
		
		this.tiposVeiculo = new ArrayList<>(getTipoVeiculoResource().findAll());
		
		this.veiculoIdentificaoManager.inicializarAba();
	}
	
	public void salvar() {
		try {
			if(editing) {
				getResource().update(this.veiculo.getIdVeiculo(), veiculo);
			} else {
				getResource().insert(this.veiculo);
			}
				
			addFacesMessage("Registro salvo com sucesso.");
			
			getExternalContext().getFlash().setKeepMessages(true);
			
			redirectTo("listagemVeiculo.xhtml");
			
		} catch(Exception e) {
			addFacesMessage(e);
		}
	}

	private TipoVeiculoResource getTipoVeiculoResource() {
		return getResource(TipoVeiculoResource.class);
	}
	
	private VeiculoResource getResource() {
		return getResource(VeiculoResource.class);
	}

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}

	public List<TipoVeiculoDTO> getTiposVeiculo() {
		return tiposVeiculo;
	}

	public void setTiposVeiculo(List<TipoVeiculoDTO> tiposVeiculo) {
		this.tiposVeiculo = tiposVeiculo;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public VeiculoIdentificaoManager getVeiculoIdentificaoManager() {
		return veiculoIdentificaoManager;
	}

	public void setVeiculoIdentificaoManager(VeiculoIdentificaoManager veiculoIdentificaoManager) {
		this.veiculoIdentificaoManager = veiculoIdentificaoManager;
	}
	
}
