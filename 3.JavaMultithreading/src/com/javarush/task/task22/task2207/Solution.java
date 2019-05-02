package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();

        while (reader.ready()) {
            list.addAll(Arrays.asList(reader.readLine().trim().split("\\s+")));
        }
        reader.close();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if(set.contains(i)) continue;
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i).equals(new StringBuilder(list.get(j)).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = list.get(j);
                    result.add(pair);
                    set.add(j);
                    break;
                }
            }
        }

        for (Pair p: result) {
            System.out.println(p);
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
