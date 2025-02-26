package com.library;


import com.library.filter.*;

import java.util.List;

public class Catalog {
    public static void main(String[] args) {
        List<PrintedProduction> available = List.of(
                new Book("Gone Girl", 510, 2012, "Grown", "Flynn",
                        null, "Thriller"),
                new Book("Montezuma's daughter", 232, 1893, "CreateSpace",
                        "Henry Ryder", null, "Historical"),
                new Magazine("Football", 32, 1998, 8, "Artem Franko"),
                new Comic("Superman", 55, 1938, 1,
                        "Jerry Siegel, Joe Schuster", "Jim Lee"),
                new Book("Thinking in Java", 1168, 1998, "Print2print",
                        "Bruce Eckel",null, "computer science"),
                new Book("head first", 678, 2002, "eskmo", "Bert Bates",
                        "Katie Sierra", "computer science"),
                new Book("toy", 55, 2001, "joy", "Bruce Eckel",
                        null, "fantasy"),
                new Book("Thinking in Java", 1168, 2007, "Print2print",
                        "Bruce Eckel",null, "computer science")
        );

        Book[] books = {
                new Book("Gone Girl", 510, 2012, "Grown", "Flynn",
                        null, "Thriller"),
                new Book("Montezuma's daughter", 232, 1893, "CreateSpace",
                        "Henry Ryder", null, "Historical"),
                new Book("Thinking in Java", 1168, 1998, "Print2print",
                        "Bruce Eckel",null, "computer science"),
                new Book("head first", 678, 2002, "eskmo", "Bert Bates",
                        "Katie Sierra", "computer science")
        };
//        printStringArray(available);

        Book book1 = new Book("witcher", 432, 2000, "heaven", "Jean",
                "Dave", "fantasy");
        Book book2 = new Book("naked gun", 225, 1995, "WB", "Jean",
                "Dave", "comedy");



//        System.out.println(contains(available, "Henry Ryder"));

        Filter userFilter = new ComplexFilter(List.of(new AuthorContainsFilter("eckeL"),
                new GenreFilter("computer science"),
                new ReleasedAfterFilter(2000),
                new FromYearTillYearFilter(2000, 2010),
                new ComicFilter()));

        List<PrintedProduction> filtered = userFilter.filter(available);
        for (int i = 0; i < filtered.size(); i++) {
            System.out.println(filtered.get(i));
        }

    }
    private static boolean contains(PrintedProduction[] printedProductions, String author) {
        Book book = new Book(null, 0, 0, null, author, null, null);
        for (int i = 0; i < printedProductions.length; i++) {
            if (printedProductions[i].equals(book)) {
                return true;
            }
        }
        return false;
    }

    private static Book[] filter(Book[] books, String genre) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getGenre().equals(genre)) {
                count++;
            }
        }
        /*
            1 идем по всем книжкам,
            2 если попадается книжка с требуемым жанром
            3 то кладем её на новую полку
            4 и запоминаем куда положили после предыдущей итерации
         */
        Book[] result = new Book[count];
        count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getGenre().equals(genre)) {
                result[count++] = books[i];
            }
        }
        return result;
    }

}

