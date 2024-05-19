package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class Leitor extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LEITOR_GENERATOR", sequenceName = "IDLEITOR", allocationSize = 1)
	@GeneratedValue(generator = "LEITOR_GENERATOR", strategy = GenerationType.SEQUENCE)
	private Long idLeitor;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String descricao;

	public Long getIdLeitor() {
		return idLeitor;
	}

	public void setIdLeitor(Long idLeitor) {
		this.idLeitor = idLeitor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public Long getId() {
		return getIdLeitor();
	}
	
}
