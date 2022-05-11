package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import static com.javarush.task.task20.task2026.RectangleUtil.*;

public class Solution {

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }



    public static int getRectangleCount(byte[][] a) {

        int count = 0;

        byte[][] tmp = new byte[a.length][a[0].length];
        System.arraycopy(a, 0, tmp, 0, a.length);

        RectangleCoordinates coordinates = new RectangleCoordinates();

        while (isPresentRectangle(tmp, coordinates)) {
            findEndCoordinateOfRectangle(tmp, coordinates);
            deleteRectangle(tmp, coordinates);
            count++;
        }

        return count;
    }

}
