package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class VeiculoIdentificacaoDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idVeiculoIdentificacao;

	private VeiculoDTO veiculo;
	
	private String UUID;

	public Long getIdVeiculoIdentificacao() {
		return idVeiculoIdentificacao;
	}

	public void setIdVeiculoIdentificacao(Long idVeiculoIdentificacao) {
		this.idVeiculoIdentificacao = idVeiculoIdentificacao;
	}

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	@Override
	public Long getId() {
		return getIdVeiculoIdentificacao();
	}
	
}
