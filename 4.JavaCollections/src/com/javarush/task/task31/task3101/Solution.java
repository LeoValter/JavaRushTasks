package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        //Принимаем параметры
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        // rename file
        File fileResult = new File(resultFileAbsolutePath.getParent() + "/" + "allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, fileResult);


        //проверяем размер файла
        List<String> fileNameList = fileParse(path.getPath());

        Collections.sort(fileNameList);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileResult);
            for (String s: fileNameList) {
                FileInputStream fileInputStream = new FileInputStream(new File(s));
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data);
                }
                fileOutputStream.write("\n".getBytes());
                fileInputStream.close();
            }

            fileOutputStream.close();

        }
        catch(Exception e) {
            
        }

    }

    public static List<String> fileParse(String path) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        for (File f: file.listFiles()) {
            if(f.isDirectory()) {
                list.addAll(fileParse(f.getPath()));
            }
            else if(f.length() <= 50) {
                list.add(f.getPath());
            }
        }

        return list;

    }


}
