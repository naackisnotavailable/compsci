package Homework7_1_29_2024;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    private List<Integer> digitList;

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

    public boolean isStrictlyIncreasing() {
        for (int i = 1; i < digitList.size(); i++) {
            if (digitList.get(i) <= digitList.get(i - 1)) {
                return false;
            }
        }
        return true;
    } 
}
