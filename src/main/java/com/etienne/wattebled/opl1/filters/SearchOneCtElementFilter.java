package com.etienne.wattebled.opl1.filters;


import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.Filter;

public class SearchOneCtElementFilter<T extends CtElement> implements Filter<T> {
	private T element;
	
	public SearchOneCtElementFilter(T element) {
		this.element = element;
	}

	public boolean matches(T element) {
		return this.element == element;
	}
	
}
