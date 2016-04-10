package com.etienne.wattebled.opl1.processors;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

import com.etienne.wattebled.opl1.filters.AllCtBlockFilter;
import com.etienne.wattebled.opl1.filters.AllCtElementFilter;

public class GeneratesReturnCtMethod extends AbstractProcessor<CtMethod<?>> {
	private String type;
			
	public boolean isToBeProcessed(CtMethod<?> method) {
		type = method.getType().toString().toUpperCase();
		return !(type.equals("VOID"));
	}
	
	public void process(CtMethod<?> method) {
		StringBuilder sb = new StringBuilder();
		sb.append("return ");
		if (method.getType().isPrimitive()) {
			if (type.equals("BOOLEAN")) {
				sb.append(" false");
			} else if (type.equals("INT") || type.equals("LONG") || type.equals("BYTE") || type.equalsIgnoreCase("FLOAT") || type.equals("DOUBLE")) {
				sb.append("0");
			}
		} else {
			sb.append("null");
		}
		List<CtBlock<?>> blocks = method.getElements(new AllCtBlockFilter(method));
		CtBlock<?> block = blocks.get(0);
		List<CtElement> elements = block.getElements(new AllCtElementFilter(block));
		CtElement element = elements.get(elements.size()-1);
		if ((!(element instanceof CtReturn)) && (element instanceof CtStatement)) {
			CtStatement statement = (CtStatement) element;
			CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
			snippet.setValue(sb.toString());
			statement.insertAfter(snippet);
		}
	}
}
