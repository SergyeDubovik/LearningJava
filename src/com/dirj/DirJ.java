package com.dirj;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirJ {
    private static final String DIR = "  <DIR>";
    private static boolean onlyFiles = false;
    private static boolean lowerCase = false;

    public static void main(String[] args) {
        for (String arg : args) {
            boolean helpOption = false;
            switch (arg.toUpperCase()) {
                case "/B":
                    onlyFiles = true;
                    break;
                case "/L":
                    lowerCase = true;
                    break;
                case "/?":
                    if (!helpOption) {
                        helpMessage();
                        return;
                    }
                    break;
                default:
                    System.out.println("Unknown argument '" + arg + "'. Use '/?' argument for help.");
                    return;
            }
        }
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
        if (!onlyFiles) {
            sb.append(getLastModifiedDate(currentDir));
            sb.append(DIR).append(" ".repeat(16)).append('.').append('\n');
            sb.append(getLastModifiedDate(currentDir.getParentFile()));
            sb.append(DIR).append(" ".repeat(16)).append("..").append('\n');
        }
        for (File child : children) {
            if (!onlyFiles) {
                sb.append(getLastModifiedDate(child));
            }
            if (child.isFile()) {
                String formatted = nf.format(child.length());
                if (!onlyFiles) {
                    sb.append(String.format("%21s", formatted));
                }
            } else {
                if (!onlyFiles) {
                    sb.append(DIR).append(" ".repeat(14));
                }
            }
            if (lowerCase) {
                sb.append("  ").append(child.getName().toLowerCase()).append('\n');
            } else {
                sb.append("  ").append(child.getName()).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static String getLastModifiedDate(File child) {
        long dateTime = child.lastModified();
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return sdf.format(date) + " ";
    }
    private static void helpMessage() {
        String message = """
                /B - Show only files
                /L - Use lower case
                """;
        System.out.println(message);
    }

}
