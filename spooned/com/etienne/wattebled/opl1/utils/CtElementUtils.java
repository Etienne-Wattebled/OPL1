package com.etienne.wattebled.opl1.utils;


public class CtElementUtils {
    public static spoon.reflect.code.CtIf getIfWhichContainsInTheExpression(CtElement element) {
        CtIf parent = element.getParent(spoon.reflect.code.CtIf.class);
        if (parent == null) {
            return null;
        } 
        if ((parent.getCondition().getElements(new com.etienne.wattebled.opl1.filters.SearchOneCtElementFilter<spoon.reflect.declaration.CtElement>(element)).size()) > 0) {
            return parent;
        } 
        return null;
    }

    public static spoon.reflect.code.CtWhile getWhileWhichContainsInTheExpression(CtElement element) {
        CtWhile parent = element.getParent(spoon.reflect.code.CtWhile.class);
        if (parent == null) {
            return null;
        } 
        if ((parent.getLoopingExpression().getElements(new com.etienne.wattebled.opl1.filters.SearchOneCtElementFilter<spoon.reflect.declaration.CtElement>(element)).size()) > 0) {
            return parent;
        } 
        return null;
    }

    public static spoon.reflect.code.CtDo getDoWhichContainsInTheExpression(CtElement element) {
        CtDo parent = element.getParent(spoon.reflect.code.CtDo.class);
        if (parent == null) {
            return null;
        } 
        if ((parent.getLoopingExpression().getElements(new com.etienne.wattebled.opl1.filters.SearchOneCtElementFilter<spoon.reflect.declaration.CtElement>(element)).size()) > 0) {
            return parent;
        } 
        return null;
    }

    public static spoon.reflect.code.CtFor getForWhichContainsInTheExpression(CtElement element) {
        CtFor parent = element.getParent(spoon.reflect.code.CtFor.class);
        if (parent == null) {
            return null;
        } 
        if ((parent.getExpression().getElements(new com.etienne.wattebled.opl1.filters.SearchOneCtElementFilter<spoon.reflect.declaration.CtElement>(element)).size()) > 0) {
            return parent;
        } 
        return null;
    }

    public static spoon.reflect.code.CtForEach getForEachWhichContainsInTheExpression(CtElement element) {
        CtForEach parent = element.getParent(spoon.reflect.code.CtForEach.class);
        if (parent == null) {
            return null;
        } 
        if ((parent.getVariable()) == element) {
            return parent;
        } 
        return null;
    }
}

