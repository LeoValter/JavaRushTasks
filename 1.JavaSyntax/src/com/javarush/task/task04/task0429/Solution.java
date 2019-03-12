package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());

        int a = 0, b = 0;

        if (number1 < 0)
            a += 1;

        else if (number1 > 0)
            b += 1;


        if (number2 < 0)
            a += 1;

        else if (number2 > 0)
            b += 1;


        if (number3 < 0)
            a += 1;

        else if (number3 > 0)
            b += 1;


        System.out.println("количество отрицательных чисел: " + a);
        System.out.println("количество положительных чисел: " + b);




    }
}
