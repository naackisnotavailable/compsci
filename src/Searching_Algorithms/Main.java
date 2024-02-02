package Searching_Algorithms;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import Sorting_Algorithms.Insertion;
import Sorting_Algorithms.QuickSort;
import Sorting_Algorithms.Selection;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            int randomNumber = random.nextInt(10_000);
            numbers.add(randomNumber);
        }

        double totTime = timer(QuickSort::quickSort, numbers);

        System.out.println("Total time taken: " + totTime + " seconds");

        ArrayList<Integer> searchNumbers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            searchNumbers.add(i);
        }

        long start = System.nanoTime();
        System.out.println(Binary.binarySearch(searchNumbers, 90000));
        long finish = System.nanoTime();

        double searchTime = (double) (finish - start) / 1000000000;

        System.out.println("Total time taken: " + searchTime + " seconds");

        
        
    }

    public static double timer(Function<ArrayList<Integer>, ?> function, ArrayList<Integer> list) {
        long start = System.nanoTime();
        function.apply(list);
        long finish = System.nanoTime();
        return (double) (finish - start) / 1000000000;
    }
}
