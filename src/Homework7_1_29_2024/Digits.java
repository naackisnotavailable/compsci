package Homework7_1_29_2024;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    private List<Integer> digitList;

    /**
     * The Digits class represents a list of digits in a given number.
     * It initializes the digitList ArrayList with the digits of the given number.
     * If the number is 0, it adds a single digit 0 to the digitList.
     * Otherwise, it extracts each digit from the number and adds it to the digitList in reverse order.
     */
    public Digits(int num) {
        digitList = new ArrayList<>();
        if (num == 0) {
            digitList.add(0);
        } else {
            while (num > 0) {
                int digit = num % 10;
                digitList.add(0, digit);
                num /= 10;
            }
        }
    }

    /**
     * Checks if the digits in the digitList are strictly increasing.
     * 
     * @return true if the digits are strictly increasing, false otherwise.
     */
    public boolean isStrictlyIncreasing() {
        for (int i = 1; i < digitList.size(); i++) {
            if (digitList.get(i) <= digitList.get(i - 1)) {
                return false;
            }
        }
        return true;
    } 
}
