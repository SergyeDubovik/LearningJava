package com.dirj;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirJ {
    public static final String DIR = "  <DIR>";
    private static boolean onlyFileNames = false;
    private static boolean lowerCase = false;

    public static void main(String[] args) {
        for (String arg : args) {
            if (parseArguments(arg)) {
                return;
            }
        }
        String currentDirName = System.getProperty("user.dir");
        File currentDir = new File(currentDirName);

        printDir(currentDir);
    }

    private static boolean parseArguments(String arg) {
        switch (arg.toUpperCase()) {
            case "/B":
                onlyFileNames = true;
                break;
            case "/L":
                lowerCase = true;
                break;
            case "/?":
                helpMessage();
                return true;
            default:
                System.out.println("Unknown argument '" + arg + "'. Use '/?' argument for help.");
                return true;
        }
        return false;
    }

    private static void printDir(File currentDir) {
        File[] children = currentDir.listFiles();
        if (children == null) {
            throw new RuntimeException();
        }
        Formatter formatter;
        if (onlyFileNames) {
            formatter = new FileNameFormatter(lowerCase);
        } else {
            formatter = new FullInfoFormatter(lowerCase);
        }
        StringBuilder sb = new StringBuilder();
        if (!onlyFileNames) {
            sb.append(getLastModifiedDate(currentDir));
            sb.append(DIR).append(" ".repeat(16)).append('.').append('\n');
            sb.append(getLastModifiedDate(currentDir.getParentFile()));
            sb.append(DIR).append(" ".repeat(16)).append("..").append('\n');
        }
        System.out.print(sb);
        for (File child : children) {
            System.out.println(formatter.format(child));
        }
    }

    public static String getLastModifiedDate(File child) {
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
