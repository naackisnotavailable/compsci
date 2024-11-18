package Homework_ArrayLists_1_19_24;

import java.util.ArrayList;

public class Main {
    /**
     * Calculates the sum of all negative values in the given ArrayList of integers.
     *
     * @param numbers the ArrayList of integers
     * @return the sum of all negative values
     */
    public static int sumNegativeValues(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }

    /**
     * Finds the longest string in the given ArrayList of strings.
     * 
     * @param strings the ArrayList of strings to search
     * @return an ArrayList containing the longest string and its length
     */
    public static ArrayList<String> findLongestString(ArrayList<String> strings) {
        String longestString = "";
        int maxLength = 0;
        for (String str : strings) {
            if (str.length() > maxLength) {
                longestString = str;
                maxLength = str.length();
            }
        }
        ArrayList<String> result = new ArrayList<>();
        result.add(longestString);
        result.add(Integer.toString(maxLength));
        return result;
    }

    /**
     * Removes strings from the given ArrayList that have a length greater than the specified length.
     *
     * @param strings the ArrayList of strings to remove from
     * @param length the maximum length of strings to keep
     * @return the modified ArrayList with strings removed
     */
    public static ArrayList<String> removeStringsGreaterThanLength(ArrayList<String> strings, int length) {
        strings.removeIf(str -> str.length() > length);
        return strings;
    }

    /**
     * Removes the elements at even indexes from the given ArrayList.
     * 
     * @param numbers the ArrayList of integers
     */
    public static void removeEvenIndexedElements(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

    /**
     * Swaps the smallest value in the given ArrayList with the value at the first index.
     * If the ArrayList is empty, it returns the same ArrayList.
     *
     * @param numbers the ArrayList of Double values
     * @return the ArrayList with the smallest value swapped with the value at the first index
     */
    public static ArrayList<Double> swapSmallestValue(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }

        double smallest = numbers.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < smallest) {
                smallest = numbers.get(i);
                smallestIndex = i;
            }
        }

        double temp = numbers.get(0);
        numbers.set(0, smallest);
        numbers.set(smallestIndex, temp);

        return numbers;
    }

    /**
     * Checks if the given ArrayList contains the specified value.
     *
     * @param numbers the ArrayList of integers to search in
     * @param value   the value to search for
     * @return true if the ArrayList contains the value, false otherwise
     */
    public static boolean containsValue(ArrayList<Integer> numbers, int value) {
        return numbers.contains(value);
    }

    /**
     * Finds the intersection of two ArrayLists.
     * Returns a new ArrayList containing the common elements between the two input ArrayLists.
     *
     * @param list1 the first ArrayList
     * @param list2 the second ArrayList
     * @return the intersection of list1 and list2
     */
    public static ArrayList<Integer> findIntersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int num : list1) {
            if (list2.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }

}

