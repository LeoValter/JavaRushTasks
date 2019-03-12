package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int toRun = Integer.parseInt(reader.readLine());

        int summ = 0;

        while (toRun != -1) {

             summ += toRun;

             toRun = Integer.parseInt(reader.readLine());
        }

        summ += toRun;

        System.out.println(summ);
    }
}
