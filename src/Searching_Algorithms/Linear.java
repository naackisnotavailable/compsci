package Searching_Algorithms;

import java.util.ArrayList;


public class Linear {
    /**
     * Performs a linear search on the given list to find the target element.
     *
     * @param list   the list to be searched
     * @param target the element to be found
     * @return the index of the target element if found, -1 otherwise
     */
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