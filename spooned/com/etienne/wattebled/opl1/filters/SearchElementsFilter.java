package com.etienne.wattebled.opl1.filters;


public class SearchElementsFilter<T extends com.etienne.wattebled.opl1.filters.CtElement> implements Filter {
    private T element;

    public SearchElementsFilter(T element) {
        this.element = element;
    }

    public boolean matches(T element) {
        return (this.element) == element;
    }
}

