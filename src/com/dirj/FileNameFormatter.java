package com.dirj;

import java.io.File;

public class FileNameFormatter implements Formatter {
    private boolean lowerCase;

    public FileNameFormatter(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    @Override
    public String format(File file) {
        return lowerCase ? file.getName().toLowerCase() : file.getName();
    }
}
