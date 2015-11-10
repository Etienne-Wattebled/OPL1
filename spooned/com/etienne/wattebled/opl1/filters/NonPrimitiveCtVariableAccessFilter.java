package com.etienne.wattebled.opl1.filters;


public class NonPrimitiveCtVariableAccessFilter implements Filter {
    public boolean matches(CtVariableAccess element) {
        return !(element.getType().isPrimitive());
    }
}

