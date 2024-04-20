package br.com.unisenaisc.intelligate.model;

import javax.persistence.Entity;

@Entity
public class Usuario {

	private Long idUsuario;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
