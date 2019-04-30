package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Burka", 3, 0));
        game.getHorses().add(new Horse("Pulya", 3, 0));
        game.getHorses().add(new Horse("Strela", 3, 0));

        game.run();
        game.printWinner();
    }

    static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    
    public void move() {
        for (Horse h: horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h: horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0;
        for (Horse h: horses) {
            if (maxDistance < h.getDistance()) maxDistance = h.getDistance();
        }
        Horse horse = null;
        for (Horse h: horses) {
            if (maxDistance == h.getDistance()) horse = h;
        }
        return horse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
