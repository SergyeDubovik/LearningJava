package com.library;

public class PrintedProduction {
    private String title;
    private int pages;
    private int yearOfRelease;
    private final int id;
    private static int nextId;


    public PrintedProduction(String name, int pages, int yearOfRelease) {
        this.title = name;
        this.pages = pages;
        this.yearOfRelease = yearOfRelease;
        this.id = nextId++;

    }

    @Override
    public String toString() {
        return "PrintedProduction {" +
                "id = " + id +
                ", title = " + title +
                ", pages = " + pages +
                ", yearOfRelease = " + yearOfRelease +
                '}';
    }

    public String getTitle() {
        return title;
    }
    public int getPages() {
        return pages;
    }
    public int getYearOfRelease() {
        return yearOfRelease;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getId() {
        return id;
    }
}
