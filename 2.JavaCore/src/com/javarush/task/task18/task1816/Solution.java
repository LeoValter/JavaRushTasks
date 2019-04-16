package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int count = 0;

        while (fileInputStream.available() > 0) {

            char c = (char) fileInputStream.read();

            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                count++;
            }

        }

        fileInputStream.close();

        System.out.println(count);



    }
}
