package com.library.filter;

import com.library.PrintedProduction;

import java.util.ArrayList;
import java.util.List;

public abstract class PredicateFilter implements Filter {
    public abstract boolean check(PrintedProduction production);
    @Override
    public List<PrintedProduction> filter(List<PrintedProduction> productions) {

        List<PrintedProduction> result = new ArrayList<>();
        for (PrintedProduction production : productions) {
            if (check(production)) {
                result.add(production);
            }
        }

        return result;
    }
}
