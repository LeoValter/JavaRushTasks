package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {

    public static void Sort(int[] array) {
        int i = 0;
        int goodPairCounter = 0;

        while (true) {
            if (array[i] > array[i + 1]) {
                int n = array[i];
                array[i] = array[i + 1];
                array[i + 1] = n;
                goodPairCounter = 0;
            }
            else {
                goodPairCounter++;
            }

            i++;

            if (i == array.length - 1) {
                i = 0;
            }

            if (goodPairCounter == array.length - 1) {
                break;
            }

        }

        i = 0;

        while (i < array.length) {
            System.out.println(array[i]);
            i++;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] arr = new int[5];

        int i = 0;

        while (i < 5) {
            arr[i] = Integer.parseInt(reader.readLine());
            i++;
        }

        Sort(arr);



    }
}
