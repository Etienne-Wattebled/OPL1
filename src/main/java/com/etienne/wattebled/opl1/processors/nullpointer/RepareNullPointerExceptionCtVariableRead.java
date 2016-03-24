package com.etienne.wattebled.opl1.processors.nullpointer;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;

import com.etienne.wattebled.opl1.utils.ElementUtils;
import com.etienne.wattebled.opl1.utils.VariableUtils;

public class RepareNullPointerExceptionCtVariableRead extends AbstractProcessor<CtVariableRead<?>> {
	private CtStatement statement;
	private CtBinaryOperator<Boolean> binaryOperatorBoolean;
	
	public boolean isToBeProcessed(CtVariableRead<?> variable) {
		statement = ElementUtils.getLastStatement(variable);
		binaryOperatorBoolean = (CtBinaryOperator<Boolean>) ElementUtils.getLastBinaryOperatorBoolean(variable);
		return (!variable.getVariable().getType().isPrimitive()) && (VariableUtils.isAVariable(variable));
	}
	
	public void process(CtVariableRead<?> variable) {
		/**
		 * Dans le cas où la variable est dans une expression booléenne
		 * Alors, on ajoute un test dans la condition pour tester si elle est == null
		 */
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
			/**
			 * Sinon,il faut créer un nouveau if
			 */
			System.out.println(variable);
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
