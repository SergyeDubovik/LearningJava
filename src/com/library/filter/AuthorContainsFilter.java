package com.library.filter;

import com.library.Book;
import com.library.PrintedProduction;

public class AuthorContainsFilter extends PredicateFilter {
    private final String author;

    public AuthorContainsFilter(String author) {
        this.author = author.toLowerCase();
    }

    @Override
    public boolean check(PrintedProduction production) {
        if (production instanceof Book) {
            Book book = (Book) production;
            if (book.getAuthor().toLowerCase().contains(author)) {
                return true;
            }
        }
        return false;
    }
}