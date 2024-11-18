package Sorting_Algorithms;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Tests class is used to test the insertion sort algorithm.
 */
public class Tests {
    public static void main(String[] args){
    	Random rand = new Random();
	ArrayList<Integer> nums = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		nums.add(rand.nextInt(200));
	}
    System.out.println(Insertion.insertionSort(nums));
}



}
