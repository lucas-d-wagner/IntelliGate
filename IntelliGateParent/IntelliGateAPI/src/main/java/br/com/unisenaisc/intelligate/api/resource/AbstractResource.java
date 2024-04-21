package br.com.unisenaisc.intelligate.api.resource;

import br.com.unisenaisc.intelligate.api.jwt.ContextRequestCache;
import br.com.unisenaisc.intelligate.context.LoginContext;

public abstract class AbstractResource {

	public LoginContext getLoginContext() {
		return ContextRequestCache.get().getLoginContext();
	}
	
}
