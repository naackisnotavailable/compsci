package Homework8_3_4_2024;

public class ArrayResizer {
    /**
     * Checks if a specific row in a 2D array contains only non-zero elements.
     *
     * @param array2D the 2D array to check
     * @param r the index of the row to check
     * @return true if the row contains only non-zero elements, false otherwise
     */
    public static boolean isNonZeroRow(int[][] array2D, int r) {
        for (int element : array2D[r]) {
            if (element == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the number of non-zero rows in a 2D array.
     *
     * @param array2D the 2D array to be checked
     * @return the number of non-zero rows in the array
     */
    public static int numNonZeroRows(int[][] array2D) {
        int count = 0;
        for (int r = 0; r < array2D.length; r++) {
            if (isNonZeroRow(array2D, r)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Resizes a 2D array by removing zero rows.
     *
     * @param array2D the original 2D array
     * @return the resized 2D array with zero rows removed
     */
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
