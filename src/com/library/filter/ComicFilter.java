package com.library.filter;

import com.library.Comic;
import com.library.PrintedProduction;

public class ComicFilter extends PredicateFilter {

    @Override
    public boolean check(PrintedProduction production) {
        return production instanceof Comic;
    }


//    @Override
//    public PrintedProduction[] filter(PrintedProduction[] productions) {
//        int count = 0;
//        for (int i = 0; i < productions.length; i++) {
//            if (productions[i] instanceof Comic) {
//                count++;
//            }
//        }
//        Comic[] result = new Comic[count];
//        count = 0;
//        for (int i = 0; i < productions.length; i++) {
//            if (productions[i] instanceof Comic) {
//                result[count++] = (Comic) productions[i];
//            }
//        }
//        return result;
//    }
}
