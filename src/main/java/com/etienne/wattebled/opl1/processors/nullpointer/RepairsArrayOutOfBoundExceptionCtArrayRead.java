package com.etienne.wattebled.opl1.processors.nullpointer;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.filters.AllCtElementFilter;
import com.etienne.wattebled.opl1.utils.CtElementUtils;

public class RepairsArrayOutOfBoundExceptionCtArrayRead extends AbstractProcessor<CtArrayRead<?>> {
	private CtBinaryOperator<Boolean> binaryOperator;
	private CtStatement statement;
	private CtElement indiceTab;
	private CtElement variableTab;
	private List<CtElement> elements;
	
	public boolean isToBeProcessed(CtArrayRead<?> element) {
		binaryOperator = CtElementUtils.getLastBinaryOperatorBoolean(element);
		statement = CtElementUtils.getLastStatement(element);
		elements = element.getElements(new AllCtElementFilter(element));
		if (elements.isEmpty() || elements.size() < 2) {
			return false;
		}
		variableTab = elements.get(0);
		indiceTab = elements.get(1);
		System.out.println("variableTab: "+variableTab);
		System.out.println("indiceTab: "+indiceTab);
		return true;
	}
	
	public void process(CtArrayRead<?> element) {

		boolean createIf = (binaryOperator == null);
		StringBuilder sb = null;
		sb=new StringBuilder();
		CtIf ctIf = null;
		CtBlock<?> ctBlock = null;
		System.out.println("1");
		if (createIf) {
			ctIf =  getFactory().Core().createIf();

			statement.replace(ctIf);

			ctBlock = getFactory().Core().createBlock();
			ctBlock.addStatement(statement);
			ctIf.setThenStatement(ctBlock);

		}
		System.out.println("2");

		CtCodeSnippetExpression<Boolean> ctExpression = getFactory().Core().createCodeSnippetExpression();
		System.out.println("3");
		sb.append("((");
		sb.append(indiceTab.toString());
		sb.append(" >= 0) && (");
		sb.append(indiceTab.toString());
		sb.append(" < ");
		sb.append(variableTab);
		sb.append(".length)");
		sb.append(")");
		if (!createIf) {
			System.out.println("4");
			sb.append(" && (");
			sb.append(binaryOperator.toString());
			sb.append(")");
		}
		ctExpression.setValue(sb.toString());
		System.out.println("expression : "+sb.toString());
		
		if (createIf) {
			ctIf.setCondition(ctExpression);
		} else {
			binaryOperator.replace(ctExpression);
		}
		System.out.println("5");
		System.out.println("BINARY OPERATOR " + " ctExpression: "+ctExpression);
	}
		
}
