package Elevens;

import java.util.Arrays;

public class ShuffleTest {
    
    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        
        // Test case 1: Array with even length
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] expected1 = {1, 4, 2, 5, 3, 6};
        boolean result1 = Arrays.equals(expected1, shuffle.perfectShuffle(arr1));
        System.out.println("Test case 1: " + result1);
        
        // Test case 2: Array with odd length
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 4, 2, 5, 3};
        boolean result2 = Arrays.equals(expected2, shuffle.perfectShuffle(arr2));
        System.out.println("Test case 2: " + result2);
        System.out.println(Arrays.toString(shuffle.perfectShuffle(arr2)));
        
        // Test case 3: Array with single element
        int[] arr3 = {1};
        int[] expected3 = {1};
        boolean result3 = Arrays.equals(expected3, shuffle.perfectShuffle(arr3));
        System.out.println("Test case 3: " + result3);
        
        // Test case 4: Empty array
        int[] arr4 = {};
        int[] expected4 = {};
        boolean result4 = Arrays.equals(expected4, shuffle.perfectShuffle(arr4));
        System.out.println("Test case 4: " + result4);
    }
}