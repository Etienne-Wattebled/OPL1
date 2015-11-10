package com.etienne.wattebled.opl1.filters;


public class NonPrimitivelCtArrayReadAndCtVariableReadFilter implements Filter {
    public boolean matches(CtExpression element) {
        return (!(element.getType().isPrimitive())) && ((element instanceof CtArrayRead) || (element instanceof CtVariableRead));
    }
}

