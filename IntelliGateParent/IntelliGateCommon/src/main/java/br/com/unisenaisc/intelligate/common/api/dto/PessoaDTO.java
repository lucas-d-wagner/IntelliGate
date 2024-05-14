package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class PessoaDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idPessoa;
	
	private TipoPessoaDTO tipoPessoa;
	
	private String cpfCnpj;
	
	private String email;

	private String telefone;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public TipoPessoaDTO getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoaDTO tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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

	@Override
	public Long getId() {
		return getIdPessoa();
	}
	
}
