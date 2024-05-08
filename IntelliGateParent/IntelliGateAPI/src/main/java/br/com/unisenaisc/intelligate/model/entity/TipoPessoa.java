package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.entity.IDescricaoCustomizada;

@Entity
public class TipoPessoa extends AbstractEntity implements IDescricaoCustomizada {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idTipoPessoa;
	
	@NotNull
	private Long codigo;
	
	@NotBlank
	private String descricao;
	
	public TipoPessoa() {}

	public TipoPessoa(Long idTipoPessoa, @NotNull Long codigo, @NotBlank String descricao) {
		this.idTipoPessoa = idTipoPessoa;
		this.codigo = codigo;
		this.descricao = descricao;
	}

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

	@Override
	public String getDescricaoCustomizada() {
		return getCodigo() + " - " + getDescricao();
	}

}
