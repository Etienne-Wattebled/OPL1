package com.etienne.wattebled.opl1.filters;


import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtVariableReadFilter implements Filter<CtVariableRead<?>> {
	private CtElement parent;
	public AllCtVariableReadFilter() {	
	}
	
	public AllCtVariableReadFilter(CtElement parent) {
		this.parent = parent;
	}
	
	public boolean matches(CtVariableRead<?> element) {
		return (parent == null) || (element.getParent() == parent);
	}
	
}
