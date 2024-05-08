package br.com.unisenaisc.intelligate.model.enums;

import br.com.unisenaisc.intelligate.architecture.entity.IEntityEnum;
import br.com.unisenaisc.intelligate.model.entity.TipoVeiculo;

public enum EnumTipoVeiculo implements IEntityEnum<TipoVeiculo> {

	CARRO(new TipoVeiculo(1L, 1L, "Carro")),
	MOTO(new TipoVeiculo(2L, 2L, "Moto"))
	;
	
	private final TipoVeiculo tipoVeiculo;
	
	private EnumTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	@Override
	public TipoVeiculo getEntity() {
		return getTipoVeiculo();
	}

}
