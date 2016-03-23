package com.etienne.wattebled.opl1.filters;


import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtVariableReadFilter<T extends CtElement> implements Filter<T> {
	public boolean matches(T element) {
		return (element instanceof CtVariableRead);
	}
	
}
