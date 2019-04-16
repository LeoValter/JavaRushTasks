package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int letters = 0;
        int spaces = 0;

        if(args.length > 0) {
            while (fileInputStream.available() >0) {
                int data = fileInputStream.read();
                letters++;
                if(data == Integer.valueOf(' ')) {
                    spaces++;
                }
            }
        }

        fileInputStream.close();

        System.out.printf("%.2f", (double) spaces / letters * 100);

    }
}
