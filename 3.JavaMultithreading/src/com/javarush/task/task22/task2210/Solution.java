package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String delimiter = ".";
        String query = "level22.lesson13.task01";
        String[] strings = getTokens(query, delimiter);
        System.out.println(Arrays.deepToString(strings));

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        String[] result = new String[tokenizer.countTokens()];
        for (int i = 0; tokenizer.hasMoreElements(); i++) {
            result[i] = tokenizer.nextToken();
        }
        return result;
    }
}
