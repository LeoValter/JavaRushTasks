package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        while (!string.equals("exit")) {

            try {
                if (string.contains(".")) {
                    print(Double.parseDouble(string));
                }
                else if ((Integer.parseInt(string)) > 0 && (Integer.parseInt(string)) < 128) {
                    print(Short.parseShort(string));
                }
                else if ((Integer.parseInt(string)) <= 0 || (Integer.parseInt(string)) >= 128) {
                    print(Integer.parseInt(string));
                }
            }
            catch (NumberFormatException e) {
                print(string);
            }

            string = reader.readLine();
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
