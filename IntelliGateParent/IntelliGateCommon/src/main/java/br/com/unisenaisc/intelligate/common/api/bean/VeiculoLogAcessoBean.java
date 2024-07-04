package br.com.unisenaisc.intelligate.common.api.bean;

import java.io.Serializable;
import java.util.Date;

public class VeiculoLogAcessoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipo;

	private String placa;
	
	private String modelo;
	
	private Date dataEntrada;
	
	private Date dataSaida;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
}
