package com.etienne.wattebled.opl1.processors.nullpointer;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.utils.CtElementUtils;
import com.etienne.wattebled.opl1.utils.CtVariableReadUtils;

public class RepairsNullPointerExceptionCtVariableRead extends AbstractProcessor<CtVariableRead<?>> {
	private CtStatement statement;
	private CtBinaryOperator<Boolean> binaryOperatorBoolean;
	
	public boolean isToBeProcessed(CtVariableRead<?> variable) {
		statement = CtElementUtils.getLastStatement(variable);
		binaryOperatorBoolean = (CtBinaryOperator<Boolean>) CtElementUtils.getLastBinaryOperatorBoolean(variable);
		return (!variable.getVariable().getType().isPrimitive())
				&& (CtVariableReadUtils.isAVariable(variable) 
				&& isToBeProcessedNullPointer(variable));
	}
	
	private boolean isToBeProcessedNullPointer(CtVariableRead<?> variable) {
		return CtVariableReadUtils.hasAccesOn(variable)
				|| CtVariableReadUtils.hasForEachAccess(variable)
				|| CtVariableReadUtils.hasCellAccess(variable);
	}
	
	public void arrayRead(CtVariableRead<?> variable, StringBuilder sb) {
		CtElement parent = variable.getParent();
		if (parent instanceof CtArrayRead) {
			CtArrayRead<?> arrayRead = (CtArrayRead<?>) parent;
			if ((!arrayRead.getType().isPrimitive()) && CtVariableReadUtils.hasAccesOn(arrayRead)) {
				sb.append(" && (");
				sb.append(arrayRead.toString());
				sb.append(" != null)");
			}
		}
	}
	
	public void process(CtVariableRead<?> variable) {
		/**
		 * Dans le cas où la variable est dans une expression booléenne
		 * Alors, on ajoute un test dans la condition pour tester si elle est == null
		 */
		StringBuilder sb = new StringBuilder();
		CtElement parent = variable.getParent();
		if (binaryOperatorBoolean != null) {
			CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
			
			sb.append("(");
			sb.append(variable.getVariable().getSimpleName());
			sb.append(" != null)");
			
			arrayRead(variable,sb);
			
			sb.append(" && (");
			sb.append(binaryOperatorBoolean.toString());
			sb.append(")");
			ctExpression.setValue(sb.toString());
			binaryOperatorBoolean.replace(ctExpression);
		} else {
			/**
			 * Sinon,il faut créer un nouveau if
			 */
			CtIf ctIf = getFactory().Core().createIf();
			statement.replace(ctIf);
			
			CtBlock<?> ctBlock = getFactory().Core().createBlock();
			ctBlock.addStatement(statement);
			
			CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
			sb.append("(");
			sb.append(variable.getVariable().getSimpleName());
			sb.append(" != null)");
			
			
			arrayRead(variable,sb);
			
			ctExpression.setValue(sb.toString());
			ctIf.setCondition(ctExpression);
			ctIf.setThenStatement(ctBlock);
		}
	}
}
