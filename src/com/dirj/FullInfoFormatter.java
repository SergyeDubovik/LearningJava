package com.dirj;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

import static com.dirj.DirJ.DIR;
import static com.dirj.DirJ.getLastModifiedDate;

public class FullInfoFormatter extends FileNameFormatter {

    public FullInfoFormatter(boolean lowerCase) {
        super(lowerCase);
    }

    @Override
    public String format(File file) {
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        StringBuilder sb = new StringBuilder();
        sb.append(getLastModifiedDate(file));
        if (file.isFile()) {
            String formatted = nf.format(file.length());
            sb.append(String.format("%21s", formatted));
        } else {
            sb.append(DIR).append(" ".repeat(14));
        }
        sb.append("  ").append(super.format(file));

        return sb.toString();
    }
}
