package Sorting_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;


// IMPORTANT: This code is completely optional, and not required (in the 2023 version) of the assignment. Don't waste any time on it if you're not interested in it.
public class QuickSort {
    public static void main(String[] args) {
        // Test the QuickSort algorithm
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 7, 6, 3));
        quickSort(arr);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        return quickSortHelper(arr, 0, arr.size() - 1);
    }

    /**
     * Helper method for performing quicksort on an ArrayList of integers.
     * This method recursively partitions the array and sorts the sub-arrays.
     *
     * @param arr  the ArrayList of integers to be sorted
     * @param low  the starting index of the sub-array
     * @param high the ending index of the sub-array
     * @return the sorted ArrayList of integers
     */
    private static ArrayList<Integer> quickSortHelper(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    /**
     * Partitions the given ArrayList of integers using the QuickSort algorithm.
     * 
     * @param arr the ArrayList of integers to be partitioned
     * @param low the starting index of the partition
     * @param high the ending index of the partition
     * @return the index of the pivot element after partitioning
     */
    public static int partition(ArrayList<Integer> arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr.get(high);

        // Index of smaller element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr.get(j) <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }
}
