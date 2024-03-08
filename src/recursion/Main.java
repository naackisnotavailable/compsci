package recursion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Call your methods here
    }

    // Problem 1
    public static void printIntegers(int first, int second) {
        if (first < second) {
            return;
        }
        System.out.println(first);
        printIntegers(first - 1, second);
    }

    // Problem 2
    public static void printMultiplesOfTwo(int n) {
        if (n == 0) {
            return;
        }
        printMultiplesOfTwo(n - 1);
        System.out.println(n * 2);
    }

    // Problem 3
    public static void printStringLetterByLetter(String str) {
        if (str.isEmpty()) {
            return;
        }
        System.out.println(str.charAt(0));
        printStringLetterByLetter(str.substring(1));
    }

    // Problem 4
    public static void printStringReverse(String str) {
        if (str.isEmpty()) {
            return;
        }
        printStringReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    // Problem 5
    public static void printStringPalindrome(String str) {
        if (str.isEmpty()) {
            return;
        }
        System.out.print(str.charAt(0));
        printStringPalindrome(str.substring(1));
        System.out.print(str.charAt(0));
    }

    // Problem 6
    public static int[] removeFirstElement(int[] arr) {
        if (arr.length <= 1) {
            return new int[0];
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }

    // Problem 7
    public static void printIntArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Problem 8
    public static void printArrayList(ArrayList<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    // Problem 9
    public static void printEvenIntArray(int[] arr) {
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
    }

    // Problem 10
    public static void printIntArrayReverse(int[] arr) {
        printIntArray(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
