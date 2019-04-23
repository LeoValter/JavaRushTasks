package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<String> listPart = new ArrayList<>();

        while (!(line = reader.readLine()).equals("end")) {
            listPart.add(line);
        }

        Collections.sort(listPart);
        String fileName = listPart.get(0).substring(listPart.get(0).indexOf("."));
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        System.out.println(file.getName());
    }
}
