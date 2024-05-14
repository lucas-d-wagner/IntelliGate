package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.entity.IDescricaoCustomizada;

@Entity
public class TipoVeiculo extends AbstractEntity implements IDescricaoCustomizada {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idTipoVeiculo;
	
	@NotNull
	private Long codigo;
	
	@NotBlank
	private String descricao;

	public TipoVeiculo() {}
	
	public TipoVeiculo(Long idTipoVeiculo, @NotNull Long codigo, @NotBlank String descricao) {
		this.idTipoVeiculo = idTipoVeiculo;
		this.codigo = codigo;
		this.descricao = descricao;
	}

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
	
	@Override
	public String getDescricaoCustomizada() {
		return getCodigo() + " - " + getDescricao();
	}

	
}
