package com.library.filter;

import com.library.PrintedProduction;

public interface Filter {
    PrintedProduction[] filter(PrintedProduction[] productions);

}