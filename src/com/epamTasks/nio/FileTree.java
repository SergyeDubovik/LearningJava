package com.epamTasks.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTree {
    public Optional<String> tree(final Path path) {
        try {
            if (path == null) {
                return Optional.empty();
            }
            if (!Files.exists(path)) {
                return Optional.empty();
            }
            if (Files.isRegularFile(path)) {
                String name = path.getFileName().toString();
                long size = Files.size(path);
                return Optional.of(name + " " + size + " bytes");
            } else {
                StringBuilder sb = new StringBuilder();
                String dir = path.getFileName().toString();
                long totalSize = directorySize(path);
                sb.append(dir).append(" ").append(totalSize).append(" bytes\n");
                List<Path> children = getSortedChildren(path);
                for (int i = 0; i < children.size(); i++) {
                    Path child = children.get(i);
                    boolean isLast = (i == children.size() - 1);
                    buildTree(child, sb, "", isLast);
                }
                return Optional.of(sb.toString());
            }
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    private long directorySize(Path dir) throws IOException {
        long size = 0;
        try (Stream<Path> pathStream = Files.list(dir)) {
            for (Path path : pathStream.toList()) {
                if (Files.isRegularFile(path)) {
                    size += Files.size(path);
                } else if (Files.isDirectory(path)) {
                    size += directorySize(path);
                }
            }
        }
        return size;
    }

    private void buildTree(Path path, StringBuilder sb, String indent, boolean isLast) throws IOException {
        String connector = isLast ? "└─ " : "├─ ";
        sb.append(indent).append(connector);
        String name = path.getFileName().toString();
        long size = Files.isDirectory(path) ? directorySize(path) : Files.size(path);
        sb.append(name).append(" ").append(size).append(" bytes\n");
        if (Files.isDirectory(path)) {
            List<Path> children = getSortedChildren(path);
            for (int i = 0; i < children.size(); i++) {
                Path child = children.get(i);
                boolean last = (i == children.size() - 1);
                String childIndent = indent + (isLast ? "   " : "│  ");
                buildTree(child, sb, childIndent, last);
            }
        }
    }

    private List<Path> getSortedChildren(Path dir) throws IOException {
        return Files.list(dir)
                .sorted((a, b) -> {
                    boolean isDirA = Files.isDirectory(a);
                    boolean isDirB = Files.isDirectory(b);
                    if (isDirA && !isDirB) {
                        return -1;
                    }
                    if (!isDirA && isDirB) {
                        return 1;
                    }
                    return a.getFileName().toString().compareToIgnoreCase(b.getFileName().toString());
                })
                .collect(Collectors.toList());
    }

}
