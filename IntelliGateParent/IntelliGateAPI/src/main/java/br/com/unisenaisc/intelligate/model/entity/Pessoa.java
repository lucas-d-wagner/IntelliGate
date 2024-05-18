package br.com.unisenaisc.intelligate.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class Pessoa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PESSOA_GENERATOR", sequenceName = "IDPESSOA", allocationSize = 1)
	@GeneratedValue(generator = "PESSOA_GENERATOR", strategy = GenerationType.SEQUENCE)
	private Long idPessoa;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "IDTIPOPESSOA")
	private TipoPessoa tipoPessoa;
	
	@NotBlank
	private String cpfCnpj;
	
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String telefone;
	
    @OneToMany(mappedBy = "pessoa")
    private Set<PessoaVeiculo> veiculos;
	
	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Set<PessoaVeiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<PessoaVeiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public Long getId() {
		return getIdPessoa();
	}

}
