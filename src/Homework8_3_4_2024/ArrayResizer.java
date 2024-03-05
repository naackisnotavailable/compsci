package Homework8_3_4_2024;

public class ArrayResizer {
    public static boolean isNonZeroRow(int[][] array2D, int r) {
        for (int element : array2D[r]) {
            if (element == 0) {
                return false;
            }
        }
        return true;
    }

    public static int numNonZeroRows(int[][] array2D) {
        int count = 0;
        for (int r = 0; r < array2D.length; r++) {
            if (isNonZeroRow(array2D, r)) {
                count++;
            }
        }
        return count;
    }

    public static int[][] resize(int[][] array2D) {
        int numNonZeroRows = numNonZeroRows(array2D);
        int[][] resizedArray = new int[numNonZeroRows][];
        int index = 0;

        for (int r = 0; r < array2D.length; r++) {
            if (isNonZeroRow(array2D, r)) {
                resizedArray[index] = array2D[r];
                index++;
            }
        }

        return resizedArray;



    }
}
