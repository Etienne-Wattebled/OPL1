package com.etienne.wattebled.opl1.filters;

import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtElementFilter implements Filter<CtElement> {
	private CtElement parent;
	
	public AllCtElementFilter(CtElement parent) {
		this.parent = parent;
	}
	public AllCtElementFilter() {
	}
	
	public boolean matches(CtElement element) {
		return (parent == null) || (element.getParent() == parent);
	}
}
