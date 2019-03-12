package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        if (number < 0)
            number = -number;

        int i = 0;
        int n = number;
        while ( n > 0) {
            n = n / 10;
            i++;
        }

        for (; i > 0; i--) {
            if (((number /(int)Math.pow(10, (i - 1))) % 2) == 0)
                even++;

            else
                odd++;

        }

        System.out.println("Even: " + even + " Odd: " + odd);




    }
}
