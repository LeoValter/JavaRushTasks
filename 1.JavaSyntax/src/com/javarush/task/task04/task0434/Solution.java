package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int i = 1;

        while (i <= 10) {
            int c = 1;

            while (c <= 10) {
                int n = c * i;

                System.out.print(n + " ");

                c++;
            }

            System.out.println("");

            i++;

        }

    }
}
