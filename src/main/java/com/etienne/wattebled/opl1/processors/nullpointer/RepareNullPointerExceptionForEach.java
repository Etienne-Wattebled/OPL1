package com.etienne.wattebled.opl1.processors.nullpointer;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtIf;

public class RepareNullPointerExceptionForEach extends AbstractProcessor<CtForEach> {
	public void process(CtForEach forEach) {
		CtIf ctIf = getFactory().Core().createIf();
		CtBinaryOperator<Boolean> ctBinaryOperator = ctIf.getFactory().Core().createBinaryOperator();
		
		ctBinaryOperator.setLeftHandOperand(forEach.getExpression());
		ctBinaryOperator.setKind(BinaryOperatorKind.NE);
		ctBinaryOperator.setRightHandOperand(getFactory().Core().createLiteral().setValue(null));
		
		ctIf.setCondition(ctBinaryOperator);
		ctIf.setThenStatement(forEach);
		
		forEach.replace(ctIf);
	}
}
