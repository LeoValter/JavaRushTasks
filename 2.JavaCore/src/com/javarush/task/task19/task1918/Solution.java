package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(consoleReader.readLine()));

            StringBuilder stringBuilder = new StringBuilder();

            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
            bufferedReader.close();

            Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
            Elements element = document.select(args[0]);

            for (Element e : element) {
                System.out.println(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
