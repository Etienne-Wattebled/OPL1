package com.etienne.wattebled.opl1.filters;

import spoon.reflect.code.CtLiteral;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtLiteralFilter implements Filter<CtLiteral<?>> {
	private CtElement parent;
	
	public AllCtLiteralFilter() {
	}

	public AllCtLiteralFilter(CtElement parent) {
		this.parent = parent;
	}
	
	public boolean matches(CtLiteral<?> element) {
		return (parent == null) || (element.getParent() == parent);
	}
}
