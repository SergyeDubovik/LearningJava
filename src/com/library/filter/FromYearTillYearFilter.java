package com.library.filter;

import com.library.PrintedProduction;

public class FromYearTillYearFilter extends PredicateFilter {
    private final int fromYear;
    private final int tillYear;

    public FromYearTillYearFilter(int fromYear, int tillYear) {
        this.fromYear = fromYear;
        this.tillYear = tillYear;
    }

    @Override
    public boolean check(PrintedProduction production) {
        int yearOfRelease = production.getYearOfRelease();
        return yearOfRelease >= fromYear && tillYear >= yearOfRelease;
    }
}


