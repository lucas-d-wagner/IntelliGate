package br.com.unisenaisc.intelligate.common.architecture.restful;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract Long getId();
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other))
			return false;
		if(!(other instanceof AbstractDTO))
			return false;
		if(this == other)
			return true;
		
		AbstractDTO otherEntity = (AbstractDTO) other;

		Long id = this.getId();
		Long otherId = otherEntity.getId();
		
		return Objects.equals(id, otherId);
	}
	
	@Override
	public int hashCode() {
		return Objects.isNull(getId()) ? super.hashCode() : getId().intValue();
	}
	
}
