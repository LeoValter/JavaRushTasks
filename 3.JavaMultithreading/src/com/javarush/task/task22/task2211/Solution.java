package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset UTF8 = Charset.forName("UTF-8");
        String fileName = args[0];
        String resultFile = args[1];

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(resultFile);

        while (inputStream.available() > 0) {
            byte[] buffer = new byte[1024];
            inputStream.read(buffer);
            String s = new String(buffer, windows1251);
            buffer = s.getBytes(UTF8);
            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
