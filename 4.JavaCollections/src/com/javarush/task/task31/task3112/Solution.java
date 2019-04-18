package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/Users/leovalter/Downloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        String fileName = urlString.substring(urlString.lastIndexOf("/"));

        Path path = Paths.get(downloadDirectory.toString() + "/" + fileName);


        URL url = new URL(urlString);
        try(InputStream inputStream = url.openStream()) {
            Path tempFile = Files.createTempFile("temp", ".tmp");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

            if(Files.notExists(downloadDirectory)) Files.createDirectory(downloadDirectory);
            if(Files.notExists(path)) Files.move(tempFile, path);

        }
        catch(Exception e) {

        }

        return path;
    }
}
