package br.com.unisenaisc.intelligate.common.api.bean;

import java.io.Serializable;
import java.util.Date;

public class VeiculosPorDataBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long nroCarros;
	
	private Long nroMotos;
	
	private Date data;

	public Long getNroCarros() {
		return nroCarros;
	}

	public void setNroCarros(Long nroCarros) {
		this.nroCarros = nroCarros;
	}

	public Long getNroMotos() {
		return nroMotos;
	}

	public void setNroMotos(Long nroMotos) {
		this.nroMotos = nroMotos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
