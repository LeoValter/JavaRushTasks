package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        if((fileInputStream.available() % 2) != 0) {
            byte[] buffer = new byte[fileInputStream.available()/2 + 1];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
        }
        else {
            byte[] buffer = new byte[fileInputStream.available()/2];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
        }

        fileOutputStream.close();

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileOutputStream = new FileOutputStream(fileName3);
        fileOutputStream.write(buffer);

        fileOutputStream.close();
        fileInputStream.close();

    }
}
