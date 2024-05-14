package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class TipoPessoaDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idTipoPessoa;
	
	private Long codigo;
	
	private String descricao;

	public Long getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Long idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
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
		return getIdTipoPessoa();
	}

}
