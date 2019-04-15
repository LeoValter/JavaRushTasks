package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Map<Integer, Integer> maxBytes = new HashMap<>();

        while (fileInputStream.available() > 0) {
            Integer data = fileInputStream.read();

            if(maxBytes.containsKey(data)) {
                maxBytes.put(data, maxBytes.get(data) + 1);
            }
            else {
                maxBytes.put(data, 1);
            }

        }

        fileInputStream.close();

        int maxValue = Integer.MIN_VALUE;

        for (int value: maxBytes.values()) {
            if(maxValue < value) maxValue = value;
        }

        for (Map.Entry<Integer, Integer> entry: maxBytes.entrySet()) {
            if(entry.getValue().equals(maxValue)) System.out.print(entry.getKey() + " ");
        }

    }
}
