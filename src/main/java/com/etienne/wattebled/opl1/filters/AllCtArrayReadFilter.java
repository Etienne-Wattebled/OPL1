package com.etienne.wattebled.opl1.filters;


import spoon.reflect.code.CtArrayRead;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtArrayReadFilter implements Filter<CtArrayRead<?>> {
	private CtElement parent;
	
	public AllCtArrayReadFilter(CtElement parent) {
		this.parent = parent;
	}
	public boolean matches(CtArrayRead<?> element) {
		return (parent == null) || (element.getParent() == parent);
	}
	
}
