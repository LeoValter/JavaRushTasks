package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        if (x1 < x2)
            return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        else
            return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public static void main(String[] args) {
        System.out.println(getDistance(3, 5, 7, 4));
    }
}
