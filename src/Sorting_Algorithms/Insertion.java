package Sorting_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Insertion {
        public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
            for (int i = 1; i < list.size(); i++) {
                insertElement(list, i);
            }
            return list;
        }

        public static void insertElement(ArrayList<Integer> list, int index) {
            int element = list.get(index);
            int i = index - 1;
            while (i >= 0 && list.get(i) > element) {
                list.set(i + 1, list.get(i));
                i--;
            }
            list.set(i + 1, element);
        }

        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>(List.of(5, 2, 8, 1, 9, 11, 19, 14, 3, 7, 6, 4, 10, 12, 13, 15, 16, 17, 18, 20, 5, 8, 19));
            insertionSort(list);
            for (int num : list) {
                System.out.print(num + " ");
            }
        }
}
