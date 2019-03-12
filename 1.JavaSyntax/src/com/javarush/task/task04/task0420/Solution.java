package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int m1, m2, m3;

        if (a >= b) {
            if (a >= c) {
                m1 = a;
                if (b >= c) {
                    m2 = b;
                    m3 = c;
                }
                else {
                    m2 = c;
                    m3 = b;
                }
            }
            else {
                m1 = c;
                m2 = a;
                m3 = b;
            }
        }
        else {
            if (b >= c) {
                m1 = b;
                if (a >= c) {
                    m2 = a;
                    m3 = c;
                }
                else {
                    m2 = c;
                    m3 = a;
                }
            }
            else {
                m1 = c;
                m2 = b;
                m3 = a;
            }
        }

        System.out.println(m1 + " " + m2 + " " + m3);

    }
}
