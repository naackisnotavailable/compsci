package Homework_ArrayLists_1_19_24;

import java.util.ArrayList;

/**
 * The MainTest class is responsible for testing the methods in the Main class.
 * It contains test methods for each method in the Main class.
 */
public class MainTest {
    public static void main(String[] args) {
        testSumNegativeValues();
        testFindLongestString();
        testRemoveStringsGreaterThanLength();
        testRemoveEvenIndexedElements();
        testSwapSmallestValue();
        testContainsValue();
        testFindIntersection();
    }

    public static void testSumNegativeValues() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        numbers.add(-4);
        numbers.add(5);

        int sum = Main.sumNegativeValues(numbers);
        System.out.println("Sum of negative values: " + sum);
    }

    public static void testFindLongestString() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");
        strings.add("date");

        ArrayList<String> result = Main.findLongestString(strings);
        System.out.println("Longest string: " + result.get(0));
        System.out.println("Length of longest string: " + result.get(1));
    }

    public static void testRemoveStringsGreaterThanLength() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");
        strings.add("date");

        ArrayList<String> result = Main.removeStringsGreaterThanLength(strings, 5);
        System.out.println("Strings after removal: " + result);
    }

    public static void testRemoveEvenIndexedElements() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Main.removeEvenIndexedElements(numbers);
        System.out.println("Numbers after removal: " + numbers);
    }

    public static void testSwapSmallestValue() {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(3.5);
        numbers.add(1.2);
        numbers.add(4.7);
        numbers.add(2.9);

        ArrayList<Double> result = Main.swapSmallestValue(numbers);
        System.out.println("Numbers after swapping: " + result);
    }

    public static void testContainsValue() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        boolean contains = Main.containsValue(numbers, 3);
        System.out.println("Contains value 3: " + contains);
    }

    public static void testFindIntersection() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);

        ArrayList<Integer> intersection = Main.findIntersection(list1, list2);
        System.out.println("Intersection: " + intersection);
    }
}