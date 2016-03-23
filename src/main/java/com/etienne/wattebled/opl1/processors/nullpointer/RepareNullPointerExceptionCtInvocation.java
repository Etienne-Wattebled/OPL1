package com.etienne.wattebled.opl1.processors.nullpointer;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.filters.AllCtElementFilter;
import com.etienne.wattebled.opl1.utils.ElementUtils;
import com.etienne.wattebled.opl1.utils.VariableUtils;

public class RepareNullPointerExceptionCtInvocation extends AbstractProcessor<CtInvocation<?>> {
	private CtVariableRead<?> variable;
	private List<CtElement> elements;
	private CtStatement statement;
	private CtBinaryOperator<Boolean> binaryOperatorBoolean;
	
	public boolean isToBeProcessed(CtInvocation<?> invocation) {
		elements = invocation.getElements(new AllCtElementFilter());
		statement = ElementUtils.getLastStatement(invocation);
		binaryOperatorBoolean = (CtBinaryOperator<Boolean>) ElementUtils.getLastBinaryOperatorBoolean(invocation);
		CtElement element = null;
		if (elements.size() >= 1) {
			element = elements.get(0);
			if (!(element instanceof CtVariableRead) && (elements.size() >= 2)) {
				element = elements.get(1);
			}
		}
		if ((element != null) && (element instanceof CtVariableRead)) {
			variable = (CtVariableRead<?>) element;
		}
		return VariableUtils.isAVariable(variable);
	}
	
	public void process(CtInvocation<?> invocation) {
		if (binaryOperatorBoolean != null) {
			CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(variable.getVariable().getSimpleName());
			sb.append(" != null) && (");
			sb.append(binaryOperatorBoolean.toString());
			sb.append(")");
			ctExpression.setValue(sb.toString());
			binaryOperatorBoolean.replace(ctExpression);
		} else {
			System.out.println(invocation);
			System.out.println("STATEMENT " + statement);
			CtIf ctIf = getFactory().Core().createIf();
			statement.replace(ctIf);
			
			CtBlock<?> ctBlock = getFactory().Core().createBlock();
			ctBlock.addStatement(statement);
			
			CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
			ctExpression.setValue(variable.getVariable().getSimpleName() + " != null");
			ctIf.setCondition(ctExpression);
			ctIf.setThenStatement(ctBlock);
		}
	}
}
