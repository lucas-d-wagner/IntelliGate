package br.com.unisenaisc.intelligate.api.cache;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.unisenaisc.intelligate.business.repository.LeitorRepository;
import br.com.unisenaisc.intelligate.common.util.CollectionsUtil;
import br.com.unisenaisc.intelligate.model.entity.Leitor;

@Singleton
public class ValidClientAddressCache {

	private final String LOCALHOST = "127.0.0.1"; 
	
	private Set<String> allowedAddresses;
	
	@Inject
	private LeitorRepository leitorRepository;
	
	public ValidClientAddressCache() {}
	
    @PostConstruct
    public void init() {
        loadAllowedAddressess();
    }
	
    public boolean isValidAddress(String address) {
    	if(allowedAddresses.contains(address)) return true;
    	return isRegisteredAddress(address);
    }

	private boolean isRegisteredAddress(String address) {
		Leitor leitor = leitorRepository.findByEndereco(address);
		
		if(leitor != null) {
			allowedAddresses.add(leitor.getEndereco());
			return true;
		}
		
		return false;
	}

	private void loadAllowedAddressess() {
		this.allowedAddresses = new HashSet<>();
		
		allowedAddresses.add(LOCALHOST);
		
		List<Leitor> leitoresCadastrados = leitorRepository.findAll();
		
		for (Leitor leitor : CollectionsUtil.notNull(leitoresCadastrados)) {
			allowedAddresses.add(leitor.getEndereco());
		}
	}
	
}
