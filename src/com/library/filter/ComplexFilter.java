package com.library.filter;

import com.library.PrintedProduction;

public class ComplexFilter implements Filter {
    private Filter[] filters;

    public ComplexFilter(Filter[] filters) {
        this.filters = filters;
    }

    @Override
    public PrintedProduction[] filter(PrintedProduction[] productions) {
//        PrintedProduction[] result = new PrintedProduction[productions.length];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = productions[i];
//        }
        for (int i = 0; i < filters.length; i++) {
            productions = filters[i].filter(productions);
        }
        return productions;
    }
}
