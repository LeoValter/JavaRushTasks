package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new LinkedList<>();
        Queue<String> queue = new PriorityQueue<>();
        File file = new File(root);

        for (File f: file.listFiles()) {
            if(f.isDirectory()) queue.add(f.getAbsolutePath());
            else list.add(f.getAbsolutePath());
        }

        while (!queue.isEmpty()) {
            file = new File(queue.poll());

            for (File f: file.listFiles()) {
                if(f.isDirectory()) queue.add(f.getAbsolutePath());
                else list.add(f.getAbsolutePath());
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("/Users/leovalter/Desktop/TestDir"));
    }
}
