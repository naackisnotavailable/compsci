package Searching_Algorithms;

import java.util.ArrayList;


public class Linear {
    public static int linearSearch(ArrayList<Integer> list, int target) {
        long start = System.nanoTime();
        System.out.println(target);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                System.out.println("found");
                return i;
            }
        }
        return -1;
    }
}