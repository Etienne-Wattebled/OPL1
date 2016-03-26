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
	
	public void process(CtVariableRead<?> variable) {
		boolean createIf = (binaryOperatorBoolean == null);
		StringBuilder sb = new StringBuilder();
		CtElement parent = variable.getParent();
		CtIf ctIf = null;
		CtBlock<?> ctBlock = null;
		
		/**
		 * Dans le cas où il faut créer un nouveau if 
		 * Ce qui signifie que la variable n'est pas dans une expression booléenne
		 */
		if (createIf) {
			/**
			 * Alors on le crée et dans le then c'est le code fautif et existant
			 */
			ctIf = getFactory().Core().createIf();
			statement.replace(ctIf);
			
			ctBlock = getFactory().Core().createBlock();
			ctBlock.addStatement(statement);
			ctIf.setThenStatement(ctBlock);
		}
		/**
		 * Dans tous les cas il faut créer une nouvelle expression pour ajouter quelque chose
		 */
		CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
		
		/**
		 * On doit toujours tester que la variable est != null
		 */
		sb.append("(");
		sb.append(variable.getVariable().getSimpleName());
		sb.append(" != null)");
		
		/**
		* Et on doit éventuellement ajouter tab[i] != null
		*/
		if (parent instanceof CtArrayRead) {
			CtArrayRead<?> arrayRead = (CtArrayRead<?>) parent;
			/**
			 * Uniquement si tab[i] n'est pas primitif et si on accède à un attribut ou une méthode
			 */
			if ((!arrayRead.getType().isPrimitive()) && CtVariableReadUtils.hasAccesOn(arrayRead)) {
				sb.append(" && (");
				sb.append(arrayRead.toString());
				sb.append(" != null)");
			}
		}
		
		/**
		 * Si le if n'était pas à créer, alors ce qui
		 * pouvait déclencher un NullPointer était dans une condition
		 * donc il faut remettre la partie existante à la fin de l'expression
		 */
		if (!createIf) {
			sb.append(" && (");
			sb.append(binaryOperatorBoolean.toString());
			sb.append(")");
		}
		/**
		 * La nouvelle expression est terminée.
		 */
		ctExpression.setValue(sb.toString());
			
		if (createIf) {
			/**
			 * Si le if était à créer il suffit de la mettre dans la condition du if
			 */
			ctIf.setCondition(ctExpression);
		} else {
			/**
			 * Sinon, il suffit de remplacer l'expression concernée
			 */
			binaryOperatorBoolean.replace(ctExpression);
		}
	}
}
