package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {

        String fileName1 = "", fileName2 = "";
        boolean flag = true;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите имя первого файла: ");
            fileName1 = bufferedReader.readLine();
            System.out.println("Введите имя второго файла: ");
            fileName2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> fileLines1 = new LinkedList<>();
        List<String> fileLines2 = new LinkedList<>();

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName2))) {

            String line;
            while ((line = bufferedReader1.readLine()) != null) {
                if (!line.equals("")) {
                    fileLines1.add(line);
                }
            }
            while ((line = bufferedReader2.readLine()) != null) {
                if (!line.equals("")) {
                    fileLines2.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        while ((fileLines1.size() | fileLines2.size()) > 0) {

            final int firstElement = 0;
            String line1, line2;

            if (fileLines1.size() == 1 & fileLines2.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, fileLines1.get(0)));
                fileLines1.remove(firstElement);
                continue;
            }
            if (fileLines1.size() == 0 & fileLines2.size() == 1) {
                lines.add(new LineItem(Type.ADDED, fileLines2.get(0)));
                fileLines2.remove(firstElement);
                continue;
            }
                line1 = fileLines1.get(firstElement);
                line2 = fileLines2.get(firstElement);

            if (Objects.equals(line1, line2)) {
                lines.add(new LineItem(Type.SAME, line1));
                fileLines1.remove(firstElement);
                fileLines2.remove(firstElement);
            } else {
                if (flag) {
                    if (fileLines1.size() > 1) {
                        line1 = fileLines1.get(firstElement + 1);
                    }
                    line2 = fileLines2.get(firstElement);

                    if (Objects.equals(line1, line2)) {
                        line1 = fileLines1.get(firstElement);
                        lines.add(new LineItem(Type.REMOVED, line1));
                        fileLines1.remove(firstElement);
                    } else {
                        flag = false;
                    }

                }

                if (!flag) {
                    if (fileLines2.size() > 1) {
                        line1 = fileLines1.get(firstElement);
                    }
                    line2 = fileLines2.get(firstElement + 1);

                    if (Objects.equals(line1, line2)) {
                        line2 = fileLines2.get(firstElement);
                        lines.add(new LineItem(Type.ADDED, line2));
                        fileLines2.remove(firstElement);
                    } else {
                        flag = true;
                    }
                }

            }
        }

        for (LineItem line : lines) {
            System.out.println(line);
        }

    }

    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}

