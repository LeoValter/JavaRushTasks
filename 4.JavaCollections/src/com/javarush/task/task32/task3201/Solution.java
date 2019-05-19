package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long position = Long.parseLong(args[1]);

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");

        if (randomAccessFile.length() < position) position = randomAccessFile.length();

        randomAccessFile.seek(position);
        randomAccessFile.write(args[2].getBytes());

        randomAccessFile.close();
    }
}
