package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(file1));
        List<Number> numberList = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] elStr = line.split(" ");
            for (String s: elStr) {
                try {
                    if (s.contains(".")) numberList.add(Double.parseDouble(s));
                    else numberList.add(Integer.parseInt(s));
                }
                catch (NumberFormatException e) {
                }
            }
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        for (Number n: numberList) {
            writer.write(n.toString() + " ");
        }
        writer.close();
    }
}
