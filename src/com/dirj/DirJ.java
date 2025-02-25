package com.dirj;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DirJ {
    private static final String DIR = "  <DIR>";
    public static void main(String[] args) {
        String currentDirName = System.getProperty("user.dir");
        File currentDir = new File(currentDirName);

        printDir(currentDir);
    }

    private static void printDir(File currentDir) {
        File[] children = currentDir.listFiles();
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        StringBuilder sb = new StringBuilder();
        if (children == null) {
            throw new RuntimeException();
        }
        sb.append(getLastModifiedDate(currentDir));
        sb.append(DIR).append(" ".repeat(16)).append('.').append('\n');
        sb.append(getLastModifiedDate(currentDir.getParentFile()));
        sb.append(DIR).append(" ".repeat(16)).append("..").append('\n');
        for (File child : children) {
            sb.append(getLastModifiedDate(child));
            if (child.isFile()) {
                String formatted = nf.format(child.length());
                sb.append(String.format("%21s", formatted));
            } else {
                sb.append(DIR).append(" ".repeat(14));
            }
            sb.append("  ").append(child.getName()).append('\n');
        }
        System.out.print(sb);
    }

    private static String getLastModifiedDate(File child) {
        long dateTime = child.lastModified();
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return sdf.format(date) + " ";
    }

}
