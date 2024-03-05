package Sorting_Algorithms;

import java.util.ArrayList;

public class Selection {
    /**
     * Finds the index of the minimum value in the given ArrayList above the specified index.
     *
     * @param list  the ArrayList of integers to search
     * @param index the index above which to find the minimum value
     * @return the index of the minimum value above the specified index, or -1 if no such value exists
     */
    public static int findMinIndexAbove(ArrayList<Integer> list, int index) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = index + 1; i < list.size(); i++) {
            if (list.get(i) < minValue) {
                minValue = list.get(i);
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Swaps the elements at the specified indices in the given list.
     *
     * @param list    the list in which the elements will be swapped
     * @param index1  the index of the first element to be swapped
     * @param index2  the index of the second element to be swapped
     */
    public static void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    /**
     * Sorts an ArrayList of integers using the selection sort algorithm.
     *
     * @param list the ArrayList of integers to be sorted
     * @return the sorted ArrayList of integers
     */
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
        
        return list;
    }
}
