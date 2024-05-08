package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class Veiculo extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idVeiculo;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	@Override
	public Long getId() {
		return getIdVeiculo();
	}
	
}
