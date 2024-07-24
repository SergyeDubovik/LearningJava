package com.library.filter;

import com.library.Book;
import com.library.PrintedProduction;

public class StrictAuthorFilter extends PredicateFilter {
    private String author;

    public StrictAuthorFilter(String author) {
        this.author = author;
    }

    @Override
    public boolean check(PrintedProduction production) {
        if (production instanceof Book) {
            Book book = (Book) production;
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return true;
            }
        }
        return false;
    }
}
