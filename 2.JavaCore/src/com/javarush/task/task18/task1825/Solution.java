package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        // Не принятый вариант
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String line;
//        List<String> listPart = new ArrayList<>();
//        FileInputStream fileInputStream = null;
//
//        while (!(line = reader.readLine()).equals("end")) {
//            File file = new File(line);
//            listPart.add(file.getAbsolutePath());
//        }
//        reader.close();
//
//        Collections.sort(listPart);
//        String fileName = listPart.get(0).split(".part")[0];
//        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//
//        for (String s: listPart) {
//            fileInputStream = new FileInputStream(s);
//            byte[] buffer = new byte[fileInputStream.available()];
//            fileInputStream.read(buffer);
//            fileOutputStream.write(buffer);
//            fileInputStream.close();
//        }
//
//        fileOutputStream.close();
//        System.out.println("Объединение файлов выполнено!");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parts = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        String nextFileName = null;
        //Читаем файлы пока не "end"
        while (true) {
            if ("end".equals(nextFileName = scanner.nextLine())) break;
            else parts.add(nextFileName);
        }
        scanner.close();
        //Сортируем коллекцию
        Collections.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        //Выходной файловый поток
        String outputFileName = parts.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        //Сливаем файлы
        for (String partsFileNames : parts) {
            fileInputStream = new FileInputStream(partsFileNames);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        fileOutputStream.close();
        System.out.println("Объединение файлов выполнено!");
    }
}
