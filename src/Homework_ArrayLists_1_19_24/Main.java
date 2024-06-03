package Homework_ArrayLists_1_19_24;

import java.util.ArrayList;

public class Main {
    public static int sumNegativeValues(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }

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

    public static ArrayList<String> removeStringsGreaterThanLength(ArrayList<String> strings, int length) {
        strings.removeIf(str -> str.length() > length);
        return strings;
    }

    public static void removeEvenIndexedElements(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

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

    public static boolean containsValue(ArrayList<Integer> numbers, int value) {
        return numbers.contains(value);
    }

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

