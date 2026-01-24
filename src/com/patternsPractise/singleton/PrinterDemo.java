package com.patternsPractise.singleton;

public class PrinterDemo {
    public static void main(String[] args) {
        Printer printer1 = Printer.getInstance();
        Printer printer2 = Printer.getInstance();
        System.out.println(printer1 == printer2); // true - the same object
        printer1.print("hey");

        PrinterInstance printer3 = PrinterInstance.PRINTER_INSTANCE;
        PrinterInstance printer4 = PrinterInstance.PRINTER_INSTANCE;
        printer3.print("Doom");
        printer4.print("Eternal");
        System.out.println(printer3 == printer4);

    }
}
