package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());

        int sNum = 0;

        if (number1 > 0)
            sNum += 1;

        else
            sNum += 0;

        if (number2 > 0)
            sNum += 1;

        else
            sNum += 0;

        if (number3 > 0)
            sNum += 1;

        else
            sNum += 0;


        System.out.println(sNum);

    }
}
