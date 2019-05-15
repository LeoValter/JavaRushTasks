package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String string = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]", "");

                for (int i = 0; i < string.length(); i++) {
                    set.add(string.charAt(i));
                }
            }

            Iterator<Character> iterator = set.iterator();

            int count = set.size() < 5 ? set.size() : 5;

            for (int i = 0; i < count; i++) {
                System.out.print(iterator.next());
            }
        }
    }
}
