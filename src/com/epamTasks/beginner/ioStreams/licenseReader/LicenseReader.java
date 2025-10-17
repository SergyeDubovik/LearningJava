package com.epamTasks.beginner.ioStreams.licenseReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LicenseReader {

    public void collectLicenses(File root, File outputFile) {
        if (root == null || outputFile == null) {
            throw new IllegalArgumentException();
        }
        if (!root.exists()) {
            throw new IllegalArgumentException();
        }
        if (!root.canRead()) {
            throw new IllegalArgumentException();
        }
        if (root.isDirectory()) {
            if (!root.canExecute()) {
                throw new IllegalArgumentException();
            }
        }
        var res = new ArrayList<String>();
        collect(root, res);
        try (var bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (var line : res) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    private void collect(File file, List<String> list) {
        if (file.isDirectory()) {
            var files = file.listFiles();
            if (files != null) {
                for (var f : files) {
                    collect(f, list);
                }
            }
        } else {
            try (var br = new BufferedReader(new FileReader(file))) {
                var lines = new ArrayList<String>();
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
                var res = parse(file, lines);
                if (res != null) {
                    list.add(res);
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }

        }
    }

    private String parse(File file, List<String> lines) {
        if (lines.isEmpty() || !lines.get(0).equals("---")) {
            return null;
        }
        var index = -1;
        for (var i = 1; i < lines.size(); i++) {
            if (lines.get(i).equals("---")) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        var licenseLines = lines.subList(1, index);
        var license = (String) null;
        var issuedBy = (String) null;
        var issuedOn = (String) null;
        var expiresOn = (String) null;
        for (var line : licenseLines) {
            if (line.startsWith("License:")) {
                license = line.substring("License:".length()).trim();
            } else if (line.startsWith("Issued by:")) {
                issuedBy = line.substring("Issued by:".length()).trim();
            } else if (line.startsWith("Issued on:")) {
                issuedOn = line.substring("Issued on:".length()).trim();
            } else if (line.startsWith("Expires on:")) {
                expiresOn = line.substring("Expires on:".length()).trim();
            }
        }
        if (license == null || issuedBy == null || issuedOn == null) {
            throw new IllegalArgumentException();
        }
        var path = file.getName();
        var sb = new StringBuilder();
        sb.append("License for ").append(path).append(" is ").append(license).append(" issued by ").append(issuedBy)
                .append(" [").append(issuedOn).append(" - ").append(expiresOn != null ? expiresOn : "unlimited").append("]");
        return sb.toString();
    }

}
