package com.dirj;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        date(currentDir);
        System.out.println("  <DIR>" + " ".repeat(16) + '.');
        date(currentDir.getParentFile());
        System.out.println("  <DIR>" + " ".repeat(16) + "..");
        for (File child : children) {
            date(child);
            if (child.isFile()) {
                String formatted = nf.format(child.length());
                System.out.printf("%21s", formatted);
            } else {
                System.out.print("  <DIR>" + " ".repeat(14));
            }
            System.out.println("  " + child.getName());
        }
    }

    private static void date(File child) {
        long dateTime = child.lastModified();
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String formatDate = sdf.format(date);
        System.out.print(formatDate);
    }

}
