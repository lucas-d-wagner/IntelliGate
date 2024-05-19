package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class LeitorDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idLeitor;
	
	private String endereco;
	
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
