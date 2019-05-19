package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Solution n) {

        if(n == null) return false;

        if(!(n instanceof Solution)) return false;

        if(this == n) return true;

        Solution solution = (Solution) n;


        if (first == solution.first || solution.first != null && first.equals(solution.first)) return true;
        if (last == solution.last || solution.last != null && last.equals(solution.last)) return true;


        return true;
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = result * 31 + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));

        Solution solution = new Solution("Donald", "Duck");
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
