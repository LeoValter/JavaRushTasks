package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        Set<Integer> integerSet = new HashSet<>();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            integerSet.add(data);
        }
        fileInputStream.close();

        List<Integer> list = new ArrayList<>(integerSet);
        Collections.sort(list);

        for (Integer i: list) {
            System.out.print(i + " ");
        }
    }
}
