package com.etienne.wattebled.opl1.processors.nullpointer;


public class RepareNullPointerExceptionBooleanExpressionsProcessor extends AbstractProcessor {
    public void process(CtExpression expression) {
        CtExpression tempExpression = expression;
        java.util.List<com.etienne.wattebled.opl1.processors.nullpointer.CtExpression<?>> elements = expression.getElements(new com.etienne.wattebled.opl1.filters.NonPrimitivelCtArrayReadAndCtVariableReadFilter());
        if (elements != null) {
            for (CtExpression e : elements) {
                if (e instanceof CtArrayRead) {
                } 
            }
        } 
        CtCodeSnippetStatement snippet1 = getFactory().Core().createCodeSnippetStatement();
        CtCodeSnippetStatement snippet2 = getFactory().Core().createCodeSnippetStatement();
        snippet2.setValue("}");
    }
}

