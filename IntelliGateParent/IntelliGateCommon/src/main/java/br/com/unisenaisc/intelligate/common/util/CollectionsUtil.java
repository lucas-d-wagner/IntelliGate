package br.com.unisenaisc.intelligate.common.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class CollectionsUtil {

	public static <T> Collection<T> notNull(Collection<T> collection) {
		return Objects.isNull(collection) ? Collections.emptyList() : collection;
	}

}
