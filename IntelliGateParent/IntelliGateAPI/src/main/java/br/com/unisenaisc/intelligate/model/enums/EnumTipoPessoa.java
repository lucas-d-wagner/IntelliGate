package br.com.unisenaisc.intelligate.model.enums;

import br.com.unisenaisc.intelligate.architecture.entity.IEntityEnum;
import br.com.unisenaisc.intelligate.model.entity.TipoPessoa;

public enum EnumTipoPessoa implements IEntityEnum<TipoPessoa> {
	
	PESSOA_FISICA(new TipoPessoa(1L, 1L, "Pessoa Física")),
	PESSOA_JURIDICA(new TipoPessoa(2L, 2L, "Pessoa Jurídica"))
	;

	private final TipoPessoa tipoPessoa;
	
	private EnumTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	@Override
	public TipoPessoa getEntity() {
		return getTipoPessoa();
	}

}
