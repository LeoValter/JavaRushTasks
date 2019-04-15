package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Map<Integer, Integer> map = new HashMap<>();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            Integer data = fileInputStream.read();

            if(map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            }
            else {
                map.put(data, 1);
            }
        }
        fileInputStream.close();

        int minValue = Integer.MAX_VALUE;

        for (int value: map.values()) {
            if(value < minValue) minValue = value;
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue().equals(minValue)) System.out.print(entry.getKey() + " ");
        }

    }
}
