package com.etienne.wattebled.opl1.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtTypedElement;

import com.etienne.wattebled.opl1.utils.CtElementUtils;
import com.etienne.wattebled.opl1.utils.CtVariableReadUtils;

public class RepairsNullPointerExceptionCtVariableRead extends AbstractProcessor<CtVariableRead<?>> {
	private CtStatement statement;
	private CtBinaryOperator<Boolean> binaryOperatorBoolean;
	
	public boolean isToBeProcessed(CtVariableRead<?> variable) {
		statement = CtElementUtils.getLastStatement(variable);
		binaryOperatorBoolean = CtElementUtils.getLastBinaryOperatorBoolean(variable);
		return (CtVariableReadUtils.isAVariable(variable)
				&& (!variable.getVariable().getType().isPrimitive())  
				&& isToBeProcessedNullPointer(variable));
	}
	
	private boolean isToBeProcessedNullPointer(CtVariableRead<?> variable) {
		if (variable.getParent(CtConstructor.class) != null) {
			return false;
		}
		if (variable.getParent(CtReturn.class) != null) {
			return false;
		}
		
		return CtVariableReadUtils.hasAttributOrMethodAccessOn(variable)
				|| CtVariableReadUtils.hasForEachAccess(variable)
				|| CtVariableReadUtils.hasCellAccess(variable);
	}
	
	public void invocationsImbriquees(CtTypedElement<?> typedElement, StringBuilder sb) {
		CtElement e = typedElement.getParent();
		while ((e instanceof CtTypedElement) && (!((CtTypedElement<?>)e).getType().isPrimitive()) && (CtVariableReadUtils.hasAttributOrMethodAccessOn(e))) {
			sb.append(" && (");
			sb.append(e.toString());
			sb.append(" != null)");
			e = e.getParent();
		}
	}
	
	public void process(CtVariableRead<?> variable) {
		boolean createIf = (binaryOperatorBoolean == null);
		StringBuilder sb = new StringBuilder();
		CtElement parent = variable.getParent();
		CtIf ctIf = null;
		CtBlock<?> ctBlock = null;
		/**
		 * Dans le cas o� il faut cr�er un nouveau if 
		 * Ce qui signifie que la variable n'est pas dans une expression bool�enne
		 */
		if (createIf) {
			/**
			 * Alors on le cr�e et dans le then c'est le code fautif et existant
			 */
			ctIf = getFactory().Core().createIf();
			statement.replace(ctIf);
			
			ctBlock = getFactory().Core().createBlock();
			ctBlock.addStatement(statement);
			ctIf.setThenStatement(ctBlock);
		}
		/**
		 * Dans tous les cas il faut cr�er une nouvelle expression pour ajouter quelque chose
		 */
		CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
		
		/**
		 * On doit toujours tester que la variable est != null
		 */
		sb.append("(");
		sb.append(variable.toString());
		sb.append(" != null)");
		
		/**
		 * Possible qu'il y ait des imbrications de getters
		 */
		invocationsImbriquees(variable,sb);
		
		/**
		 * Si le if n'�tait pas � cr�er, alors ce qui
		 * pouvait d�clencher un NullPointer �tait dans une condition
		 * donc il faut remettre la partie existante � la fin de l'expression
		 */
		if (!createIf) {
			sb.append(" && (");
			sb.append(binaryOperatorBoolean.toString());
			sb.append(")");
		}
		/**
		 * La nouvelle expression est termin�e.
		 */
		ctExpression.setValue(sb.toString());
			
		if (createIf) {
			/**
			 * Si le if �tait � cr�er il suffit de la mettre dans la condition du if
			 */
			ctIf.setCondition(ctExpression);
		} else {
			/**
			 * Sinon, il suffit de remplacer l'expression concern�e
			 */
			binaryOperatorBoolean.replace(ctExpression);
		}
	}
}
