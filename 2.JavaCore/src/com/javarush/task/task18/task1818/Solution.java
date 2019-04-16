package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filrName1 = reader.readLine();
        String filrName2 = reader.readLine();
        String filrName3 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(filrName2);
        FileOutputStream fileOutputStream = new FileOutputStream(filrName1, true);
        int data;
        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        fileInputStream.close();

        fileInputStream = new FileInputStream(filrName3);

        while (fileInputStream.available() > 0) {

            data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileOutputStream.close();
        fileInputStream.close();

    }
}
