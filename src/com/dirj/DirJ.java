package com.dirj;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

public class DirJ {
    public static void main(String[] args) {
        String currentDirName = System.getProperty("user.dir");
        File currentDir = new File(currentDirName);
        printDir(currentDir);
    }

    private static void printDir(File currentDir) {
        File[] children = currentDir.listFiles();
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        if (children == null) {
            throw new RuntimeException();
        }
        System.out.println("<DIR>" + " ".repeat(16) + '.');
        System.out.println("<DIR>" + " ".repeat(16) + "..");
        for (File child : children) {
            if (child.isFile()) {
                String formatted = nf.format(child.length());
                System.out.printf("%19s", formatted);
            } else {
                System.out.print("<DIR>" + " ".repeat(14));
            }
            System.out.println("  " + child.getName());
        }
    }
}
