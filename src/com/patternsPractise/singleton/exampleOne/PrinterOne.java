package com.patternsPractise.singleton.exampleOne;

public class PrinterOne {

    private PrinterOne() {}

    private static class Holder {
        private static final PrinterOne INSTANCE = new PrinterOne();
    }

    public static PrinterOne getInstance() {
        return Holder.INSTANCE;
    }

    public void print(String text) {
        System.out.println("Printing: " + text);
    }
}
