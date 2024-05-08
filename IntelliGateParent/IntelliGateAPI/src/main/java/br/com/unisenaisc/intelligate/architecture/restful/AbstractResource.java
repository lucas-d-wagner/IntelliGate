package br.com.unisenaisc.intelligate.architecture.restful;

import br.com.unisenaisc.intelligate.api.jwt.ContextRequestCache;
import br.com.unisenaisc.intelligate.common.context.LoginContext;

public abstract class AbstractResource {

	public LoginContext getLoginContext() {
		return ContextRequestCache.get().getLoginContext();
	}
	
}
