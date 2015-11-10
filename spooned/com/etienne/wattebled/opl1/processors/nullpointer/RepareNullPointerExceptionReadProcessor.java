package com.etienne.wattebled.opl1.processors.nullpointer;


public class RepareNullPointerExceptionReadProcessor extends AbstractProcessor {
    @java.lang.Override
    public boolean isToBeProcessed(CtVariableRead element) {
        return (!(element.getType().isPrimitive())) && (element.getType().toString().equals("Boolean"));
    }

    public void process(CtVariableRead element) {
        CtExpression ctExpression = element.getParent(spoon.reflect.code.CtExpression.class);
        CtCodeSnippetStatement snippet1 = getFactory().Core().createCodeSnippetStatement();
        snippet1.setValue((("if (" + (element.getVariable().getSimpleName())) + "!= null) {"));
        CtCodeSnippetStatement snippet2 = getFactory().Core().createCodeSnippetStatement();
        snippet2.setValue("}");
    }
}

