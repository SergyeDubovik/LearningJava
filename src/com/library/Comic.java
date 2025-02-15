package com.library;

public class Comic extends Magazine {
    private String illustrator;

    public Comic(String name, int pages, int yearOfRelease, int monthlyPeriodicity, String chiefEditor,
                 String illustrator) {
        super(name, pages, yearOfRelease, monthlyPeriodicity, chiefEditor);
        this.illustrator = illustrator;
    }

    @Override
    public String toString() {
        return "Comic = { " +
                "id: " + getId() +
                ", Name: " + getTitle() +
                ", Pages: " + getPages() +
                ", Release: " + getYearOfRelease() +
                ", Monthly periodicity: " + getMonthlyPeriodicity() +
                ", Illustrator: " + getIllustrator() +
                ", Chief Editor: " + getChiefEditor() +
                '}';
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }
}
