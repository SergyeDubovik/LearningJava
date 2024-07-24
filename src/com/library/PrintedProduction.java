package com.library;

public class PrintedProduction {
    private String name;
    private int pages;
    private int yearOfRelease;


    public PrintedProduction(String name, int pages, int yearOfRelease) {
        this.name = name;
        this.pages = pages;
        this.yearOfRelease = yearOfRelease;

    }
    @Override
    public String toString() {
        return "PrintedProduction { " +
                "name = '" + name + '\'' +
                "pages = '" + pages + '\'' +
                "yearOfRelease '" + yearOfRelease + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }
    public int getPages() {
        return pages;
    }
    public int getYearOfRelease() {
        return yearOfRelease;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

}
