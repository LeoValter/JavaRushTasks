package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if(string == null || string.isEmpty()) throw new TooShortStringException();
        String[] strings;

        strings = string.split(" ");

        if(strings.length < 5) throw new TooShortStringException();

        return strings[1] + " " + strings[2] + " " + strings[3] + " " + strings[4];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
