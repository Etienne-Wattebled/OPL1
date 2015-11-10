package com.etienne.wattebled.opl1.filters;

import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class AllCtElementFilter implements Filter<CtElement> {
	public boolean matches(CtElement element) {
		return true;
	}
}
