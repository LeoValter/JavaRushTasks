package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try(RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            byte[] buffer = new byte[text.length()];
            file.seek(number);
            file.read(buffer, 0, buffer.length);
            String result = text.equals(new String(buffer)) ? "true" : "false";
            file.seek(file.length());
            file.write(result.getBytes());
        }

    }
}
