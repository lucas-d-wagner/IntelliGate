package br.com.unisenaisc.intelligate.common.api.bean;

import java.io.Serializable;
import java.util.Date;

public class DashboardFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date mesReferencia = new Date();
	
	private Date dataInicio = new Date();
	
	private Date dataFim = new Date();

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
