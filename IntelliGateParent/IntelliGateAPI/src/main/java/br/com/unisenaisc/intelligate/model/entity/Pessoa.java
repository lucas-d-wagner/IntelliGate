package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class Pessoa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idPessoa;
	
	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public Long getId() {
		return getIdPessoa();
	}

}
