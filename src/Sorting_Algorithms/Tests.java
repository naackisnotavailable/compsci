package Sorting_Algorithms;

import java.util.ArrayList;
import java.util.Random;

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
