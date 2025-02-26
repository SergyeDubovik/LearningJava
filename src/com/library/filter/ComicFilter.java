package com.library.filter;

import com.library.Comic;
import com.library.PrintedProduction;

public class ComicFilter extends PredicateFilter {

    @Override
    public boolean check(PrintedProduction production) {
        return production instanceof Comic;
    }
}
