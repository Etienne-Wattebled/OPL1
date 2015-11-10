package com.etienne.wattebled.opl1.processors.nullpointer;

import java.util.List;

import com.etienne.wattebled.opl1.filters.NonPrimitivelCtArrayReadAndCtVariableReadFilter;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtExpression;

public class RepareNullPointerExceptionBooleanExpressionsProcessor extends AbstractProcessor<CtExpression<Boolean>> {
	public void process(CtExpression<Boolean> expression) {
		CtExpression<Boolean> tempExpression = expression;
		List<CtExpression<?>> elements = expression.getElements(new NonPrimitivelCtArrayReadAndCtVariableReadFilter());
		if (elements != null) {
			for (CtExpression<?> e: elements) {
				if (e instanceof CtArrayRead) {
					
				}
				
			}
		}
		
		
		
		CtCodeSnippetStatement snippet1 = getFactory().Core().createCodeSnippetStatement();
	//	snippet1.setValue("if ("+element.getVariable().getSimpleName() + "!= null) {");
		CtCodeSnippetStatement snippet2 = getFactory().Core().createCodeSnippetStatement();
		snippet2.setValue("}");
	}
}
