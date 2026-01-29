package com.patternsPractise.adapter;

public class AdapterPrinter implements NewPrinter {

    private final OldPrinter oldPrinter;

    public AdapterPrinter(OldPrinter printer) {
        this.oldPrinter = printer;
    }
    @Override
    public void print(String text) {
        oldPrinter.printText(text);
    }
}
