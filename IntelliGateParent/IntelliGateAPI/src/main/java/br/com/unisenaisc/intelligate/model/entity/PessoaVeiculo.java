package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class PessoaVeiculo extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PESSOAVEICULO_GENERATOR", sequenceName = "IDPESSOAVEICULO", allocationSize = 1)
	@GeneratedValue(generator = "PESSOAVEICULO_GENERATOR", strategy = GenerationType.SEQUENCE)
	private Long idPessoaVeiculo;

	@NotNull
    @ManyToOne
    @JoinColumn(name = "IDPESSOA")
	private Pessoa pessoa;

	@NotNull
    @ManyToOne
    @JoinColumn(name = "IDVEICULO")
	private Veiculo veiculo;
	
	public Long getIdPessoaVeiculo() {
		return idPessoaVeiculo;
	}

	public void setIdPessoaVeiculo(Long idPessoaVeiculo) {
		this.idPessoaVeiculo = idPessoaVeiculo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public Long getId() {
		return getIdPessoaVeiculo();
	}
	
}
