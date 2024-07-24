package com.library.filter;

import com.library.PrintedProduction;

public class ReleasedAfterFilter extends PredicateFilter {
    private int year;

    public ReleasedAfterFilter(int year) {
        this.year = year;
    }

    @Override
    public boolean check(PrintedProduction production) {
        return production.getYearOfRelease() > year;
    }
}

