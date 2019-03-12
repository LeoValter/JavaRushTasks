package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());

        if (number1 > number2) {
            if (number2 > number3)
                System.out.println(number2);

            else
                if (number3 > number1)
                    System.out.println(number1);

                else
                    System.out.println(number3);
        }

        else {
            if (number1 > number3)
                System.out.println(number1);

            else
                if (number3 > number2)
                    System.out.println(number2);

                else
                    System.out.println(number3);
        }

    }
}
