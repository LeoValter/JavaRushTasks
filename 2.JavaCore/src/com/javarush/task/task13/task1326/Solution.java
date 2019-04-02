package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        List<Integer> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            
            reader.close();
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(list);

        for (Integer i: list) {
            if ((i % 2) == 0) System.out.println(i);
        }
    }
}
