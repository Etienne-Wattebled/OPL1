package com.etienne.wattebled.opl1.utils;

import java.util.HashSet;

import spoon.reflect.code.CtVariableRead;

public class VariableUtils {
	private static HashSet<String> libraryVariables;
	
	static {
		libraryVariables = new HashSet<String>();
		libraryVariables.add("java.io.PrintStream");
		libraryVariables.add("java.lang.System.out");
	}
	
	public static boolean isAVariable(CtVariableRead<?> variable) {
		return (variable != null) && !(libraryVariables.contains(variable.getType().getQualifiedName()));
	}
}
