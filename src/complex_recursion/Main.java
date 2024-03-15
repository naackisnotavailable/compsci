package complex_recursion;

public class Main {
    public static void main(String[] args) {
        int count8 = countDigit8(888888);
        System.out.println("Number of 8s: " + count8);

        int countHi = countSubstringHi("hihihihi");
        System.out.println("Number of 'hi': " + countHi);
    }

    public static int countDigit8(int number) {
        if (number == 0) {
            return 0;
        } else if (number % 10 == 8) {
            return 1 + countDigit8(number / 10);
        } else {
            return countDigit8(number / 10);
        }
    }

    public static int countSubstringHi(String str) {
        if (str.length() < 2) {
            return 0;
        } else if (str.substring(0, 2).equals("hi")) {
            return 1 + countSubstringHi(str.substring(1));
        } else {
            return countSubstringHi(str.substring(1));
        }
    }

    public static int countDigit6AtIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            return 0;
        } else if (array[index] == 6) {
            return 1 + countDigit6AtIndex(array, index + 1);
        } else {
            return countDigit6AtIndex(array, index + 1);
        }
    }
}
