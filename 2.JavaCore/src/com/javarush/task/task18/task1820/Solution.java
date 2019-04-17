package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        Scanner scanner = new Scanner(new FileInputStream(fileName1));

        String str = scanner.nextLine();
        scanner.close();

        String[] strings = str.split(" ");
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        for (String s: strings) {
            double digit = Double.parseDouble(s);
            Long data = Math.round(digit);
            fileOutputStream.write(data.toString().getBytes());
            fileOutputStream.write(32);
        }

        fileOutputStream.close();

    }
}
