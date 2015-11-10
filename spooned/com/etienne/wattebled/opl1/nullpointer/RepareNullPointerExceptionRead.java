package com.etienne.wattebled.opl1.nullpointer;


public class RepareNullPointerExceptionRead extends AbstractProcessor {
    public void process(CtVariableRead element) {
        CtCodeSnippetStatement snippet1 = getFactory().Core().createCodeSnippetStatement();
        snippet1.setValue((("if (" + (element.getVariable().getSimpleName())) + "!= null) {"));
        CtCodeSnippetStatement snippet2 = getFactory().Core().createCodeSnippetStatement();
        snippet2.setValue("}");
    }
}

