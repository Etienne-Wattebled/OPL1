package com.etienne.wattebled.opl1.filters;


import spoon.reflect.code.CtBlock;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtBlockFilter implements Filter<CtBlock<?>> {
	private CtElement parent;
	
	public AllCtBlockFilter(CtElement parent) {
		this.parent = parent;
	}
	public AllCtBlockFilter() {
		this.parent = null;
	}
	
	public boolean matches(CtBlock<?> element) {
		return (parent == null) || (element.getParent() == parent);
	}
}
