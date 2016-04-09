package com.etienne.wattebled.opl1.processors;

import java.util.HashMap;
import java.util.LinkedList;
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
	
	private HashMap<String,LinkedList<CtElement>> declarations;
	
	public SeparatesDeclarationInitialization() {
		declarations = new HashMap<String,LinkedList<CtElement>>();
	}
	
	public boolean isToBeProcessed(CtLocalVariable<?> localVariable) {
		statement = CtElementUtils.getLastStatement(localVariable);
		elements = localVariable.getElements(new AllCtElementFilter(localVariable));
		
		if (elements.size() < 1) {
			return false;
		}
		return true;
	}
	public void process(CtLocalVariable<?> localVariable) {
		String id = localVariable.getSimpleName();
		LinkedList<CtElement> list = declarations.get(id);
		if (list == null) {
			list = new LinkedList<CtElement>();
			declarations.put(id,list);
		}
		StringBuilder sb = new StringBuilder();

		if (!(CtElementUtils.hasAnElementInTheSameBlock(localVariable,list))) {
			CtCodeSnippetStatement declaration = getFactory().Core().createCodeSnippetStatement();
			sb.append(localVariable.getType());
			sb.append(" ");
			sb.append(localVariable.getSimpleName());
			declaration.setValue(sb.toString());
			statement.insertBefore(declaration);
			list.add(declaration);
		}

		CtCodeSnippetStatement initialization = getFactory().Core().createCodeSnippetStatement();
		sb = new StringBuilder();
		sb.append(localVariable.getSimpleName());
		sb.append(" = ");
		sb.append(localVariable.getDefaultExpression());
		
		initialization.setValue(sb.toString());
		localVariable.replace(initialization);
	}
}
