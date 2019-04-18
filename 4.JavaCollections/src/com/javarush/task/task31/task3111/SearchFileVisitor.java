package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean partOfNameFilter = true;
        boolean partOfContentFilter = true;
        boolean minSizeFilter = true;
        boolean maxSizeFilter = true;

        if(partOfName != null) {
            if(file.getFileName().toString().contains(partOfName)) {
                partOfNameFilter = true;
            }
            else {
                partOfNameFilter = false;
            }
        }
        if(partOfContent != null) {
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                int count = 0;
                while ((line = reader.readLine()) != null) {
                    if(line.contains(partOfContent)) {
                        count++;
                    }
                }

                if(count == 0) partOfContentFilter = false;
            }
        }
        if(minSize != 0) {
            if(minSize > content.length) minSizeFilter = false;
        }
        if(maxSize != 0) {
            if(maxSize < content.length) maxSizeFilter = false;
        }

        if(partOfNameFilter && partOfContentFilter && minSizeFilter && maxSizeFilter) foundFiles.add(file);

            return super.visitFile(file, attrs);
    }
}
