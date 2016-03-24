package com.etienne.wattebled.opl1.utils;

import java.util.List;

import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtDo;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.filters.AllCtElementFilter;
import com.etienne.wattebled.opl1.filters.OneCtElementFilter;

public class ElementUtils {
	public static CtIf getIfWhichContainsInTheExpression(CtElement element) {
		CtIf parent = element.getParent(CtIf.class);
		if (parent == null) {
			return null;
		}
		if (parent.getCondition().getElements(new OneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtWhile getWhileWhichContainsInTheExpression(CtElement element) {
		CtWhile parent = element.getParent(CtWhile.class);
		if (parent == null) {
			return null;
		}
		if (parent.getLoopingExpression().getElements(new OneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtDo getDoWhichContainsInTheExpression(CtElement element) {
		CtDo parent = element.getParent(CtDo.class);
		if (parent == null) {
			return null;
		}
		if (parent.getLoopingExpression().getElements(new OneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtFor getForWhichContainsInTheExpression(CtElement element) {
		CtFor parent = element.getParent(CtFor.class);
		if (parent == null) {
			return null;
		}
		if (parent.getExpression().getElements(new OneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtForEach getForEachWhichContainsInTheExpression(CtElement element) {
		CtForEach parent = element.getParent(CtForEach.class);
		if (parent == null) {
			return null;
		}
		if (parent.getVariable() == element) {
			return parent;
		}
		return null;
	}
	public static CtBlock<?> getBlockWhichContains(CtElement element) {
		CtBlock<?> parent = element.getParent(CtBlock.class);
		if (parent == null) {
			return null;
		}
		if (parent.getElements(new OneCtElementFilter<CtElement>(element)).size() > 0) {
			return parent;
		}
		return null;
	}
	public static CtInvocation<?> getFirstInvocation(CtInvocation element) {
		if (element == null) {
			return null;
		}
		CtInvocation currentInvocation = element.getParent(CtInvocation.class);
		CtInvocation invocation = null;
		while (currentInvocation != null) {
			invocation = currentInvocation;
			currentInvocation = currentInvocation.getParent(CtInvocation.class);
		}
		return (invocation==null)?element:invocation;
	}
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
	
	public static CtBinaryOperator<?> getLastBinaryOperatorBoolean(CtElement element) {
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
			return binaryOperator;
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
		if (parent instanceof CtLocalVariable) {
			return false;
		}
		if (parent instanceof CtFor) {
			return false;
		}
		return true;
	}
}