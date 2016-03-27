package com.etienne.wattebled.opl1.utils;

import java.util.List;

import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
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
		if (element == null) {
			return false;
		}
		if (!(element instanceof CtStatement)) {
			return false;
		}
		
		CtElement parent = element.getParent();
		if (parent instanceof CtInvocation) {
			return false;
		}
		if ((parent instanceof CtLocalVariable) || (parent instanceof CtAssignment)) {
			return false;
		}
		if ((parent instanceof CtFor) || (parent instanceof CtForEach)) {
			return false;
		}
		return true;
	}
}