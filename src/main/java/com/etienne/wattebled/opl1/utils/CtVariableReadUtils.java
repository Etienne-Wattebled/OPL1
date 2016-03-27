package com.etienne.wattebled.opl1.utils;

import java.util.HashSet;
import java.util.List;

import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtFieldAccess;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.filters.AllCtElementFilter;

public class CtVariableReadUtils {
	private static HashSet<String> libraryVariables;
	
	static {
		libraryVariables = new HashSet<String>();
		libraryVariables.add("java.io.PrintStream");
		libraryVariables.add("java.lang.System.out");
	}
	
	public static boolean isAVariable(CtVariableRead<?> variable) {
		return (variable != null) && !(libraryVariables.contains(variable.getType().getQualifiedName()));
	}
	
	public static boolean hasMethodCalledOn(CtElement variableRead) {
		if (variableRead == null) {
			return false;
		}
		CtElement parent = variableRead.getParent();
		if (parent instanceof CtInvocation) {
			List<CtElement> elements = parent.getElements(new AllCtElementFilter(parent));
			if (!elements.isEmpty()) {
				/**
				 return (elements.size() >= 1) && (elements.get(0) == variableRead)
						|| ((elements.size() >= 2) && (elements.get(1) == variableRead));
						**/
				return (elements.size() >= 1) && (elements.get(0) == variableRead);
			}
		}
		return false;
	}
	
	public static boolean hasAttributAccessOn(CtElement variableRead) {
		if (variableRead == null) {
			return false;
		}
		CtElement parent = variableRead.getParent();

		if (parent instanceof CtFieldAccess) {
			List<CtElement> elements = parent.getElements(new AllCtElementFilter(parent));
			if (!elements.isEmpty()) {
				return (elements.size() >= 1) && (elements.get(0) == variableRead)
						|| ((elements.size() >= 2) && (elements.get(1) == variableRead));
			}
		}
		return false;
	}
	public static boolean hasForEachAccess(CtVariableRead<?> variableRead) {
		if (variableRead == null) {
			return false;
		}
		CtElement parent = variableRead.getParent();
		if (parent instanceof CtForEach) {
			List<CtElement> elements = parent.getElements(new AllCtElementFilter(parent));
			if (!elements.isEmpty()) {
				 return elements.contains(variableRead);
			}
		}
		return false;
	}
	public static boolean hasCellAccess(CtElement variableRead) {
		if (variableRead == null) {
			return false;
		}
		CtElement parent = variableRead.getParent();
		if (parent instanceof CtArrayRead) {
			CtArrayRead<?> arrayRead = (CtArrayRead<?>) parent;
			List<CtElement> elements = parent.getElements(new AllCtElementFilter(parent));
			if (!elements.isEmpty()) {
				return elements.contains(variableRead);		
			}
		}
		return false;
	}
	
	public static boolean hasAttributOrMethodAccessOn(CtElement variable) {
		return hasMethodCalledOn(variable) || hasAttributAccessOn(variable);
	}
}
