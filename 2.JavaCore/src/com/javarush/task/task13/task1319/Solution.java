package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            File file = new File(fileName);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            String line;

            while (!(line = reader.readLine()).equals("exit")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.write(line);

            reader.close();
            bufferedWriter.close();
            fileWriter.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
