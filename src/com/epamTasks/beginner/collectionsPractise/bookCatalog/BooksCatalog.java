package com.epamTasks.beginner.collectionsPractise.bookCatalog;

import java.util.*;

public class BooksCatalog {
    private static final String EOL = "\n";
    private Map<Author, List<Book>> catalog;

    public BooksCatalog() {
        catalog = new TreeMap<>();
    }

    public BooksCatalog(Map<Author, List<Book>> catalog) {
        if (catalog == null) {
            throw new NullPointerException();
        }
        this.catalog = new TreeMap<>(catalog);
    }

    /**
     * Returns a List of books of the specified author.
     *
     * @param author the author of books to search for.
     * @return a list of books or {@code null}
     * if there is no such author in the catalog.
     */
    public List<Book> findByAuthor(Author author) {
        if (author == null) {
            throw new NullPointerException();
        }
        return catalog.get(author);
    }

    /**
     * @return the string representation of all authors
     * separated by the current operating system {@code lineSeparator}.
     */
    public String getAllAuthors() {
        StringBuilder sb = new StringBuilder();
        Iterator<Author> authorIterator = catalog.keySet().iterator();
        while (authorIterator.hasNext()) {
            Author author = authorIterator.next();
            sb.append(author.getFirstName()).append(" ").append(author.getLastName());
            if (authorIterator.hasNext()) {
                sb.append(EOL);
            }
        }
        return sb.toString();
    }

    /**
     * Searches for pairs of (author, book) by the book title.
     * The pair must be included in the resulting map if the
     * book title contains the specified string matched ignore case.
     * All authors of the book must be specified in the
     * book authors list.
     *
     * @param pattern the string to search for in the book title.
     * @return the map which contains all found books and their authors.
     * It must be sorted by titles of books, if the titles match,
     * by increasing cost.
     */
    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        if (pattern == null) {
            throw new NullPointerException();
        }
        TreeMap<Book, List<Author>> res = new TreeMap<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            Author author = entry.getKey();
            List<Book> books = entry.getValue();
            for (Book book : books) {
                String title = book.getTitle();
                if (title.toLowerCase().contains(pattern.toLowerCase())) {
                    if (res.containsKey(book)) {
                        res.get(book).add(author);
                    } else {
                        List<Author> authors = new ArrayList<>();
                        authors.add(author);
                        res.put(book, authors);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            return null;
        }
        return res;
    }

    /**
     * Searches for all books whose genre list contains the specified string.
     * The book must be included in the resulting list if at least
     * one genre of the book contains the specified pattern ignoring case.
     *
     * @param pattern the string to search for in the book genre list.
     * @return a set of books sorted using natural ordering.
     * @see Book class.
     */
    public Set<Book> findBooksByGenre(String pattern) {
        if (pattern == null) {
            throw new NullPointerException();
        }
        Set<Book> result = new TreeSet<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            List<Book> books = entry.getValue();
            for (Book book : books) {
                List<String> genres = book.getGenres();
                for (String genre : genres) {
                    if (genre.toLowerCase().contains(pattern.toLowerCase())) {
                        result.add(book);
                        break;
                    }
                }
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    /**
     * Searches for authors of the specified book.
     *
     * @param book the book.
     * @return a list of authors of the specified book.
     * @throws NullPointerException if the parameter is {@code null}
     */
    public List<Author> findAuthorsByBook(Book book) {
        if (book == null) {
            throw new NullPointerException();
        }
        List<Author> foundAuthors = new ArrayList<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            Author author = entry.getKey();
            List<Book> books = entry.getValue();
            if (books.contains(book)) {
                foundAuthors.add(author);
            }
        }
        return foundAuthors.isEmpty() ? Collections.emptyList() : foundAuthors;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
//            Author author = entry.getKey();
//            List<Book> books = entry.getValue();
//            sb.append(author.toString()).append(": ").append("\n");
//            for (Book book : books) {
//                sb.append("  ").append(book.toString()).append("\n");
//            }
//        }
//        return sb.toString();
        return catalog.toString();
    }

}
