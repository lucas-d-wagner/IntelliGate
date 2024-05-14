package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class VeiculoDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idVeiculo;
	
	private TipoVeiculoDTO tipoVeiculo;
	
	private String placa;

	private String modelo;
	
	private String marca;
	
	private Long ano;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public TipoVeiculoDTO getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculoDTO tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	@Override
	public Long getId() {
		return getIdVeiculo();
	}
	
}
