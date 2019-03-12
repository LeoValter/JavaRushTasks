package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        if (this.age < 2 || this.age > 7) {
            if (anotherCat.age < 2 && anotherCat.age > 7) {
                if (this.strength > anotherCat.strength)
                    return true;

                else if (this.strength < anotherCat.strength)
                    return false;

                else {
                    if (this.weight > anotherCat.weight)
                        return true;

                    else
                        return false;
                }
            }

            else
                return false;
        }

        else if (anotherCat.age < 2 && anotherCat.age > 7) {
            return true;
        }

        else {
            if (this.strength > anotherCat.strength)
                return true;

            else if (this.strength < anotherCat.strength)
                return false;

            else {
                if (this.weight > anotherCat.weight)
                    return true;

                else
                    return false;
            }

        }


    }

    public static void main(String[] args) {

    }
}
