package br.com.unisenaisc.intelligate.common.api.dto;

import java.io.Serializable;

public class PayloadResponseDTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private T data;

	public PayloadResponseDTO(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
