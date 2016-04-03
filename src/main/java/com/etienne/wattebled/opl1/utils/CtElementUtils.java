package com.etienne.wattebled.opl1.utils;

import java.util.List;

import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.filters.AllCtElementFilter;

public class CtElementUtils {
	public static CtStatement getLastStatement(CtElement element) {
		if (element == null) {
			return null;
		}
		CtElement courant = element;
		while ((courant != null) && (!canGenerateCodeAround(courant))) {
			courant = courant.getParent();
		}
		return (courant == null)?null:(CtStatement)courant;
	}
	
	public static CtBinaryOperator<Boolean> getLastBinaryOperatorBoolean(CtElement element) {
		if (element == null) {
			return null;
		}
		CtBinaryOperator<?> binaryOperator = element.getParent(CtBinaryOperator.class);
		if (binaryOperator == null) {
			return null;
		}
		List<CtElement> list = binaryOperator.getElements(new AllCtElementFilter());
		if (!list.contains(element)) {
			return null;
		}
		if (binaryOperator.getType().getSimpleName().toUpperCase().equals("BOOLEAN")) {
			return (CtBinaryOperator<Boolean>) binaryOperator;
		}
		return null;
	}
	
	public static boolean canGenerateCodeAround(CtElement element) {
		CtElement parent = element.getParent();
		return parent instanceof CtBlock;
	}
}