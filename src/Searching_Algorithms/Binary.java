package Searching_Algorithms;

import java.util.ArrayList;

public class Binary {
    public static int binarySearch(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (arr.get(middle) == target) {
                return middle;
            }

            if (target < arr.get(middle)) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

        }

        return -1;
    }
}
