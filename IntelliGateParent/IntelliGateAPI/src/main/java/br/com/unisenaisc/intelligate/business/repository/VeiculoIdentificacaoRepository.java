package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

@ManagedBean
public class VeiculoIdentificacaoRepository extends GenericRepositoryImpl<VeiculoIdentificacao> {

	@Override
	public Class<VeiculoIdentificacao> getEntityClass() {
		return VeiculoIdentificacao.class;
	}

	public VeiculoIdentificacao findByUUID(String UUID) {
		TypedQuery<VeiculoIdentificacao> typedQuery = createTypedQuery("SELECT v FROM VeiculoIdentificacao v WHERE v.UUID = :UUID");
		typedQuery.setParameter("UUID", UUID);
		return getSingleResult(typedQuery);
	}
	
}
