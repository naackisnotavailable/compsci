package Sorting_Algorithms;

import java.util.ArrayList;

public class Selection {
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

    public static void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

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
