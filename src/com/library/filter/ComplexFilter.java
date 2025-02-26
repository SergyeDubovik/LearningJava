package com.library.filter;

import com.library.PrintedProduction;

import java.util.List;

public class ComplexFilter implements Filter {
    private List<Filter> filters;

    public ComplexFilter(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public List<PrintedProduction> filter(List<PrintedProduction> productions) {
        for (Filter filter : filters) {
            productions = filter.filter(productions);
        }
        return productions;
    }
}
