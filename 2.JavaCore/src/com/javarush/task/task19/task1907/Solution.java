package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();


        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        int count = 0;
        String word = "world";
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.toString().split("\\W");
            for (String s : words)
                if (s.equals(word))
                    count++;
        }
        fileReader.close();

        System.out.println(count);
    }
}
