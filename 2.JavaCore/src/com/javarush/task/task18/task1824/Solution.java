package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                fileName = reader.readLine();
                try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

                }
                catch(FileNotFoundException e) {
                    System.out.println(fileName);
                    break;
                }
            }
        }
        catch(IOException e) {

        }

    }
}
