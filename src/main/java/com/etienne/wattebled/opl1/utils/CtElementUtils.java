package com.etienne.wattebled.opl1.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
	public static boolean hasAnElementInTheSameBlock(CtElement element,LinkedList<CtElement> elements) {
		LinkedList<CtBlock<?>> list = getAllCtBlockParent(element);
		Set<CtBlock<?>> s = new HashSet<CtBlock<?>>();
		for (CtElement e : elements) {
			s.addAll(getAllCtBlockParent(e));
		}

		for (CtElement e : list) {
			if (s.contains(e)) {
				return true;
			}
		}
		return false;
	}
	public static LinkedList<CtBlock<?>> getAllCtBlockParent(CtElement element) {
		LinkedList<CtBlock<?>> result = new LinkedList<CtBlock<?>>();
		CtBlock<?> parent = null;
		while ((parent = element.getParent(CtBlock.class)) != null) {
			result.add(parent);
			element = parent;
		}
		return result;
	}
}