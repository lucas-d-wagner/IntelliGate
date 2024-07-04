package br.com.unisenaisc.intelligate.business.repository;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.LogAcesso;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;

@ManagedBean
public class LogAcessoRepository extends GenericRepositoryImpl<LogAcesso> {

	@Override
	public Class<LogAcesso> getEntityClass() {
		return LogAcesso.class;
	}
	
	public LogAcesso findUltimoByVeiculo(Veiculo veiculo) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT la FROM LogAcesso la ");
		sb.append(" WHERE la.veiculo = :veiculo ");
		sb.append(" ORDER BY la.dataHoraEntrada DESC ");
		
		TypedQuery<LogAcesso> typedQuery = createTypedQuery(sb.toString());
		typedQuery.setParameter("veiculo", veiculo);
		typedQuery.setMaxResults(1);
		
		return getSingleResult(typedQuery);
	}
	
	public List<LogAcesso> findWithInterval(Date dataInicio, Date dataFim) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT la FROM LogAcesso la ");
		sb.append(" WHERE la.dataHoraEntrada >= :dataInicio AND la.dataHoraEntrada <= :dataFim ");
		
		TypedQuery<LogAcesso> typedQuery = createTypedQuery(sb.toString());
		typedQuery.setParameter("dataInicio", dataInicio);
		typedQuery.setParameter("dataFim", dataFim);

		return getResultList(typedQuery);
	}

}
