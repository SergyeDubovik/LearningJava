package com.library.filter;

import com.library.Book;
import com.library.PrintedProduction;

public class GenreFilter extends PredicateFilter {
    private String genre;

    public GenreFilter(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean check(PrintedProduction production) {
        if (production instanceof Book) {
            Book book = (Book) production;
            return book.getGenre().equals(genre);
        }
        return false;
    }
}
