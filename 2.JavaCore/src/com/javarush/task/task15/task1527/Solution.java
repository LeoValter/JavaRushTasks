package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String result = reader.readLine();
        reader.close();

        int index = result.indexOf("?");
        result = result.substring(index + 1);

        String[] param = result.split("&");

        for (String s: param) {
            if (s.contains("=")) System.out.print(s.split("=")[0] + " ");
            else System.out.print(s + " ");
        }

        System.out.println();

        for (String s: param) {
            String value = null;
            if (s.contains("obj")) {
                value = s.split("=")[1];
            }

            try {
                alert((Double.parseDouble(value)));
            }
            catch (NumberFormatException e) {
                alert(value);
            }
            catch (NullPointerException ignored) {}

        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
