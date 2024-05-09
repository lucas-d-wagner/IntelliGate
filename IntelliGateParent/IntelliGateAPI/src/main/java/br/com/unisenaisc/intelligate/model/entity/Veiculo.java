package br.com.unisenaisc.intelligate.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class Veiculo extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "VEICULO_GENERATOR", sequenceName = "IDVEICULO", allocationSize = 1)
	@GeneratedValue(generator = "VEICULO_GENERATOR", strategy = GenerationType.SEQUENCE)
	private Long idVeiculo;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "IDTIPOVEICULO")
	private TipoVeiculo tipoVeiculo;
	
	@NotBlank
	private String placa;

	@NotBlank
	private String modelo;
	
	@NotBlank
	private String marca;
	
	@NotNull
	private Long ano;
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	@Override
	public Long getId() {
		return getIdVeiculo();
	}
	
}
