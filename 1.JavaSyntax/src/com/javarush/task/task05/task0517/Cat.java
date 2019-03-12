package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String color;
    private String address;

    public Cat(String name) {
        this.name = name;
        this.age = 1;
        this.weight = 3;
        this.color = "grey";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "grey";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 3;
        this.color = "grey";
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = 1;
    }

    public  Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 1;
    }

    public static void main(String[] args) {

    }
}
