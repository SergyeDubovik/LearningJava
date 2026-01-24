package com.patternsPractise.singleton;

public enum PrinterInstance {
    PRINTER_INSTANCE;

    public void print(String text) {
        System.out.println("Printing text: " + text);
    }
}
