package com.patternsPractise.adapter;

public class PrinterDemo {
    public static void main(String[] args) {
        OldPrinter printer = new OldPrinter();
        NewPrinter newPrinter = new AdapterPrinter(printer);
        newPrinter.print("this is adapter pattern");
    }
}
