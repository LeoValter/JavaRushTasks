package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static String fileName;
    public static Properties p = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        p.clear();

        for (Map.Entry<String, String> pair: properties.entrySet()) {
            p.put(pair.getKey(), pair.getValue());
        }

        p.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        p.load(inputStream);

        for (Map.Entry<Object, Object> pair: p.entrySet()) {
            properties.put(pair.getKey().toString(), pair.getValue().toString());
        }
    }

    public static void main(String[] args) {

    }
}
