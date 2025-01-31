package com.library;

public class Magazine extends PrintedProduction {
    private int monthlyPeriodicity;
    private String chiefEditor;

    public Magazine(String name, int pages, int yearOfRelease, int monthlyPeriodicity, String chiefEditor) {
        super(name, pages, yearOfRelease);
        this.monthlyPeriodicity = monthlyPeriodicity;
        this.chiefEditor = chiefEditor;
    }

    @Override
    public String toString() {
        return "Magazine = {" +
                "Name: " + getTitle() + '\'' +
                ", Pages: " + getPages() + '\'' +
                ", Release: " + getYearOfRelease() + '\'' +
                ", monthlyPeriodicity: " + monthlyPeriodicity +
                ", chiefEditor: " + chiefEditor +
                '}';
    }

    public int getMonthlyPeriodicity() {
        return monthlyPeriodicity;
    }
    public String getChiefEditor() {
        return chiefEditor;
    }

    public void setMonthlyPeriodicity(int monthlyPeriodicity) {
        this.monthlyPeriodicity = monthlyPeriodicity;
    }
    public void setChiefEditor(String chiefEditor) {
        this.chiefEditor = chiefEditor;
    }
}
