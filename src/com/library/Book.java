package com.library;

import java.util.Objects;

public class Book extends PrintedProduction {
    private String publisher;
    private String author;
    private String anotherAuthor;
    private String genre;

    public Book(String name, int pages, int yearOfRelease, String publisher, String author, String anotherAuthor,
                String genre) {
        super(name, pages, yearOfRelease);
        this.publisher = publisher;
        this.author = author;
        this.anotherAuthor = anotherAuthor;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book = { " +
                "id: " + getId() +
                ", Name: " + getTitle() +
                ", Pages: " + getPages() +
                ", Release: " + getYearOfRelease() +
                ", publisher: " + publisher +
                ", author: " + author +
                ", anotherAuthor: " + anotherAuthor +
                ", genre: " + genre +
                '}';
    }

    public String getPublisher() {
        return publisher;
    }
    public String getAuthor() {
        return author;
    }
    public String getAnotherAuthor() {
        return anotherAuthor;
    }
    public String getGenre() {
        return genre;
    }
    public void setPublisher() {
        this.publisher = publisher;
    }
    public void setAuthor() {
        this.author = author;
    }
    public void setAnotherAuthor() {
        this.anotherAuthor = anotherAuthor;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(anotherAuthor, book.anotherAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, anotherAuthor);
    }
}
