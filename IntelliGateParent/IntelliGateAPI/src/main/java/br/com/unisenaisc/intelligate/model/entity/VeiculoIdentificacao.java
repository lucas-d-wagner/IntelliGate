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
public class VeiculoIdentificacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "VEICULOIDENTIFICACAO_GENERATOR", sequenceName = "IDVEICULOIDENTIFICACAO", allocationSize = 1)
	@GeneratedValue(generator = "VEICULOIDENTIFICACAO_GENERATOR", strategy = GenerationType.SEQUENCE)
	private Long idVeiculoIdentificacao;

	@NotNull
    @ManyToOne
    @JoinColumn(name = "IDVEICULO")
	private Veiculo veiculo;
	
	private String UUID;

	public Long getIdVeiculoIdentificacao() {
		return idVeiculoIdentificacao;
	}

	public void setIdVeiculoIdentificacao(Long idVeiculoIdentificacao) {
		this.idVeiculoIdentificacao = idVeiculoIdentificacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	@Override
	public Long getId() {
		return getIdVeiculoIdentificacao();
	}
	
}
