package com.Day5;
import java.util.*;

public class ContainDuplicateDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                System.out.println("true");
                return;
            }
            set.add(n);
        }
        System.out.println("false");
    }
}

