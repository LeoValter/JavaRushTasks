package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String string;
        while ((string = reader.readLine()) != null) {
            String[] strArr = string.split(" ");
            if(id == Integer.parseInt(strArr[0])) {
                System.out.println(string);
                break;
            }
        }
        reader.close();

    }

}
