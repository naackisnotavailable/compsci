package Searching_Algorithms;

import java.util.ArrayList;

public class Binary {
    /**
     * Performs binary search on the given ArrayList to find the index of the target element.
     *
     * @param arr    the ArrayList to be searched
     * @param target the target element to be found
     * @return the index of the target element if found, -1 otherwise
     */
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
