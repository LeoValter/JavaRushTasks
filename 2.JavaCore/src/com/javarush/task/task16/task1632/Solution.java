package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {

    }

    static {
        threads.add(new Thread(new firstThread()));
        threads.add(new Thread(new secondThread()));
        threads.add(new Thread(new thirdThread()));
        threads.add(new fourthThread());
        threads.add(new Thread(new fifthThread()));
    }

    public static class firstThread implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class secondThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class thirdThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class fourthThread extends Thread implements Message {

        private boolean stop = false;

        @Override
        public void showWarning() {
            stop = true;
        }

        public void run() {
            while (!stop) {

            }
        }
    }

    public static class fifthThread implements Runnable {

        int sum;
        String str;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    str = reader.readLine();
                        sum += Integer.parseInt(str);
                } catch (IOException e) {
                }
                catch (NumberFormatException e) {
                    if (str.equals("N")) break;
                }

                System.out.println(sum);
            }
        }
    }
}