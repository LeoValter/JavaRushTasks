package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        FileInputStream fileInputStream;

        while (true) {
            try {
                fileName = reader.readLine();
                fileInputStream = new FileInputStream(fileName);

                if(fileInputStream.available() < 1000) {
                    reader.close();
                    fileInputStream.close();
                    throw new DownloadException();
                }

                fileInputStream.close();

            } catch(IOException e) {
            }

        }
    }

    public static class DownloadException extends Exception {
        public DownloadException() {

        }
    }
}
