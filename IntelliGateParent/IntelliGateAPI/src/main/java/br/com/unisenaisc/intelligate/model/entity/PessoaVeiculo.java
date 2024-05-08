package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class PessoaVeiculo extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idPessoaVeiculo;

	public Long getIdPessoaVeiculo() {
		return idPessoaVeiculo;
	}

	public void setIdPessoaVeiculo(Long idPessoaVeiculo) {
		this.idPessoaVeiculo = idPessoaVeiculo;
	}

	@Override
	public Long getId() {
		return getIdPessoaVeiculo();
	}
	
}
