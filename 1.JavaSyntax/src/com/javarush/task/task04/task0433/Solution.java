package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int i = 10;

        while (i > 0) {

            int c = 10;

            while (c > 1) {
                System.out.print("S");
                c--;
            }

            System.out.println("S");

            i--;
        }
    }
}
