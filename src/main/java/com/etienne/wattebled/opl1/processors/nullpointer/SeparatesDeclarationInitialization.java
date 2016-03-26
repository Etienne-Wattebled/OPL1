package com.etienne.wattebled.opl1.processors.nullpointer;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;

import com.etienne.wattebled.opl1.filters.AllCtElementFilter;
import com.etienne.wattebled.opl1.utils.CtElementUtils;

public class SeparatesDeclarationInitialization extends AbstractProcessor<CtLocalVariable<?>> {
	private CtStatement statement;
	private List<CtElement> elements;
	
	public boolean isToBeProcessed(CtLocalVariable<?> localVariable) {
		statement = CtElementUtils.getLastStatement(localVariable);
		elements = localVariable.getElements(new AllCtElementFilter());
		
		if (elements.size() <= 1) {
			return false;
		}
		return true;
	}
	public void process(CtLocalVariable<?> localVariable) {
		CtCodeSnippetStatement declaration = getFactory().Core().createCodeSnippetStatement();
		StringBuilder sb = new StringBuilder();
		sb.append(localVariable.getType());
		sb.append(" ");
		sb.append(localVariable.getSimpleName());
		declaration.setValue(sb.toString());
		statement.insertBefore(declaration);
		CtCodeSnippetStatement initialization = getFactory().Core().createCodeSnippetStatement();
		sb = new StringBuilder();
		sb.append(localVariable.getSimpleName());
		sb.append(" = ");
		sb.append(localVariable.getDefaultExpression());
		initialization.setValue(sb.toString());
		localVariable.replace(initialization);
	}
}
