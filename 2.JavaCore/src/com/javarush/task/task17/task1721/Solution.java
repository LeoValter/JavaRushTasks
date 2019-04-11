package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                allLines.add(line);
            }

            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)));

            while ((line = bufferedReader.readLine()) != null) {
                forRemoveLines.add(line);
            }

            reader.close();
            bufferedReader.close();



        } catch (IOException e) {

        }

        Solution solution = new Solution();

        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
        }

        for (String s: allLines) {
            System.out.print(s);
        }
        System.out.println();
        for (String s: forRemoveLines) {
            System.out.print(s);
        }
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
