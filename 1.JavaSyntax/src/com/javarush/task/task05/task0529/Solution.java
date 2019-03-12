package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String textStream = reader.readLine();
        int summ = 0;

        while (true) {

            if (textStream.equals("сумма"))
                break;

            else {
                int num = Integer.parseInt(textStream);
                summ = summ + num;
            }

            textStream = reader.readLine();

        }

        System.out.println(summ);
    }
}
