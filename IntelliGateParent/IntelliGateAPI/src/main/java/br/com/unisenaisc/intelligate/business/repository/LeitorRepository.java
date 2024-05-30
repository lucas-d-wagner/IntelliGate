package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.Leitor;

@ManagedBean
public class LeitorRepository extends GenericRepositoryImpl<Leitor> {

	@Override
	public Class<Leitor> getEntityClass() {
		return Leitor.class;
	}
	
	public Leitor findByEndereco(String endereco) {
		TypedQuery<Leitor> typedQuery = createTypedQuery("SELECT l FROM Leitor l WHERE l.endereco = :endereco");
		typedQuery.setParameter("endereco", endereco);
		return getSingleResult(typedQuery);
	}

}
