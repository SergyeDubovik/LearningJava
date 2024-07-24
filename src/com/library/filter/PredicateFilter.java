package com.library.filter;

import com.library.PrintedProduction;

public abstract class PredicateFilter implements Filter {
    public abstract boolean check(PrintedProduction production);

    @Override
    public PrintedProduction[] filter(PrintedProduction[] productions) {
        int count = 0;
        for (int i = 0; i < productions.length; i++) {
            if (check(productions[i])) {
                count++;
            }
        }

        PrintedProduction[] result = new PrintedProduction[count];
        count = 0;
        for (int i = 0; i < productions.length; i++) {
            if (check(productions[i])) {
                result[count++] = productions[i];
            }
        }

        return result;
    }
}
