package com.etienne.wattebled.opl1.utils;

import com.etienne.wattebled.opl1.filters.SearchOneCtElementFilter;

import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtDo;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtElement;

public class CtElementUtils {
	public static CtIf getIfWhichContainsInTheExpression(CtElement element) {
		CtIf parent = element.getParent(CtIf.class);
		if (parent == null) {
			return null;
		}
		if (parent.getCondition().getElements(new SearchOneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtWhile getWhileWhichContainsInTheExpression(CtElement element) {
		CtWhile parent = element.getParent(CtWhile.class);
		if (parent == null) {
			return null;
		}
		if (parent.getLoopingExpression().getElements(new SearchOneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtDo getDoWhichContainsInTheExpression(CtElement element) {
		CtDo parent = element.getParent(CtDo.class);
		if (parent == null) {
			return null;
		}
		if (parent.getLoopingExpression().getElements(new SearchOneCtElementFilter<CtElement>(element)).size()>0) {
			return parent;
		}
		return null;
	}
	public static CtFor getForWhichContainsInTheExpression(CtElement element) {
		CtFor parent = element.getParent(CtFor.class);
		if (parent == null) {
			return null;
		}
		if (parent.getExpression().getElements(new SearchOneCtElementFilter<CtElement>(element)).size()>0) {
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
		if (parent.getElements(new SearchOneCtElementFilter<CtElement>(element)).size() > 0) {
			return parent;
		}
		return null;
	}
}