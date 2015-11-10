package com.etienne.wattebled.opl1.filters;

import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.visitor.Filter;

public class NonPrimitivelCtArrayReadAndCtVariableReadFilter implements Filter<CtExpression<?>> {
	public boolean matches(CtExpression<?> element) {
		return !element.getType().isPrimitive() && 
				(element instanceof CtArrayRead || element instanceof CtVariableRead);
	}
}
