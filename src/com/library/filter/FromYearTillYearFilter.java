package com.library.filter;

import com.library.PrintedProduction;

public class FromYearTillYearFilter extends PredicateFilter {
    private int fromYear;
    private int tillYear;

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
//    @Override
//    public PrintedProduction[] filter(PrintedProduction[] productions) {
//        int count = 0;
//        for (int i = 0; i < productions.length; i++) {
//            int yearOfRelease = productions[i].getYearOfRelease();
//            if (yearOfRelease >= fromYear && tillYear >= yearOfRelease) {
//                count++;
//            }
//        }
//
//
//        PrintedProduction[] result = new PrintedProduction[count];
//        count = 0;
//        for (int i = 0; i < productions.length; i++) {
//            int yearOfRelease = productions[i].getYearOfRelease();
//            if (yearOfRelease >= fromYear && tillYear >= yearOfRelease) {
//                result[count++] = productions[i];
//            }
//        }
//
//        return result;
//    }

