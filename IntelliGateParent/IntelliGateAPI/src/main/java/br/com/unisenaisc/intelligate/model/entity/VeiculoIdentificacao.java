package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class VeiculoIdentificacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idVeiculoIdentificao;

	public Long getIdVeiculoIdentificao() {
		return idVeiculoIdentificao;
	}

	public void setIdVeiculoIdentificao(Long idVeiculoIdentificao) {
		this.idVeiculoIdentificao = idVeiculoIdentificao;
	}

	@Override
	public Long getId() {
		return getIdVeiculoIdentificao();
	}
	
}
