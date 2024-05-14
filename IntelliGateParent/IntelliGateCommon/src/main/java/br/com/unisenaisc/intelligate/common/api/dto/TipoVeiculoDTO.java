package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class TipoVeiculoDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idTipoVeiculo;
	
	private Long codigo;
	
	private String descricao;

	public Long getIdTipoVeiculo() {
		return idTipoVeiculo;
	}

	public void setIdTipoVeiculo(Long idTipoVeiculo) {
		this.idTipoVeiculo = idTipoVeiculo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public Long getId() {
		return getIdTipoVeiculo();
	}

	
}
