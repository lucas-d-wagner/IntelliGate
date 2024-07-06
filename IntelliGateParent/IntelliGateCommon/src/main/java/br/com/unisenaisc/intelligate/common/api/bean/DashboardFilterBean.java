package br.com.unisenaisc.intelligate.common.api.bean;

import java.io.Serializable;
import java.util.Date;

public class DashboardFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dataConsulta;

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
