package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        for (int i = 1; i <= 10; i++) {

            for (int c = i; c > 0; c--) {
                System.out.print("8");
            }

            System.out.println();
        }

    }
}
