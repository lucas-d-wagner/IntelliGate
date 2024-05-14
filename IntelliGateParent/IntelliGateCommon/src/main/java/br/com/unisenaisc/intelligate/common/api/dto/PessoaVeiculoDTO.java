package br.com.unisenaisc.intelligate.common.api.dto;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;

public class PessoaVeiculoDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Long idPessoaVeiculo;

	private PessoaDTO pessoa;

	private VeiculoDTO veiculo;

	public Long getIdPessoaVeiculo() {
		return idPessoaVeiculo;
	}

	public void setIdPessoaVeiculo(Long idPessoaVeiculo) {
		this.idPessoaVeiculo = idPessoaVeiculo;
	}

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public Long getId() {
		return getIdPessoaVeiculo();
	}
	
}
