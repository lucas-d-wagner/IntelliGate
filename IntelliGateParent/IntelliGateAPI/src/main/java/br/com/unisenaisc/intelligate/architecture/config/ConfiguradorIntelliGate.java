package br.com.unisenaisc.intelligate.architecture.config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.model.entity.TipoPessoa;
import br.com.unisenaisc.intelligate.model.entity.TipoVeiculo;
import br.com.unisenaisc.intelligate.model.enums.EnumTipoPessoa;
import br.com.unisenaisc.intelligate.model.enums.EnumTipoVeiculo;

@Startup
@Singleton
public class ConfiguradorIntelliGate {

	@PersistenceContext
	private EntityManager entityManager;
	
    @PostConstruct
    public void init() {
        configurar();
    }
    
    private void configurar() {
    	popularEnums();
    }
    
    private void popularEnums() {
    	popularTipoPessoa();
    	popularTipoVeiculo();
    }
    
    private void popularTipoPessoa() {
    	for (EnumTipoPessoa enumTipoPessoa : EnumTipoPessoa.values()) {
    		TipoPessoa tipoPessoa = enumTipoPessoa.getEntity();
    		mergeOrPersist(TipoPessoa.class, tipoPessoa);
    	}
    }
    
    private void popularTipoVeiculo() {
    	for (EnumTipoVeiculo enumTipoVeiculo : EnumTipoVeiculo.values()) {
    		TipoVeiculo tipoVeiculo = enumTipoVeiculo.getEntity();
    		mergeOrPersist(TipoVeiculo.class, tipoVeiculo);
		}
    }
    
    private <E extends AbstractEntity> void mergeOrPersist(Class<E> clazz, E entity) {
        E managedEntity = entityManager.find(clazz, entity.getId());
        if (managedEntity != null) {
            entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
        }
    }
	
}
