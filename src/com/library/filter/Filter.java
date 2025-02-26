package com.library.filter;

import com.library.PrintedProduction;

import java.util.List;

public interface Filter {
    List<PrintedProduction> filter(List<PrintedProduction> productions);

}