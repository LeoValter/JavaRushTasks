package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }

    }

    public static class ReadThread extends Thread {

        Map<Integer, Integer> bytesFreq = new HashMap<>();

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int b = fileInputStream.read();
                    if(bytesFreq.containsKey(b)) {
                        bytesFreq.put(b, bytesFreq.get(b) + 1);
                    }
                    else {
                        bytesFreq.put(b, 1);
                    }
                }

                fileInputStream.close();

                int max = Collections.max(bytesFreq.values());

                for (Map.Entry<Integer, Integer> entry: bytesFreq.entrySet()) {
                    if(max == entry.getValue()) {
                        resultMap.put(fileName, entry.getKey());
                    }
                }

            } catch(IOException e) {

            }
        }
    }
}
