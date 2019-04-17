package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);

        Map<Character, Integer> simbolMap = new TreeMap<>();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();

            if(data >= 0 && data <= 127) {
                if(simbolMap.containsKey((char) data)) {
                    simbolMap.put((char) data, simbolMap.get((char) data)+ 1);
                }
                else simbolMap.put((char) data, 1);
            }

        }
        fileInputStream.close();



        for (Map.Entry<Character, Integer> entry: simbolMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
