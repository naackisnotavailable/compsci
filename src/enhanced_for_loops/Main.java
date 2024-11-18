package enhanced_for_loops;

public class Main {
    /**
     * Calculates the sum of each row in a 2D array and returns an array containing the sums.
     *
     * @param arr the 2D array to calculate the row sums for
     * @return an array containing the sum of each row in the input array
     */
    public static int[] rowSum(int[][] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        for (int[] row : arr) {
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            result[i++] = sum;
        }
        return result;
    }
    /**
     * Calculates the column sums of a 2D array.
     *
     * @param arr The 2D array for which column sums need to be calculated.
     * @return An array containing the sums of each column.
     */
    public static int[] colSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[] result = new int[cols];
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += arr[i][j];
            }
            result[j] = sum;
        }
        return result;
    }
    /**
     * Finds the maximum value in each row of a 2D array and returns an array containing the maximum values.
     *
     * @param arr the 2D array to find the maximum values from
     * @return an array containing the maximum value from each row of the input array
     */
    public static int[] maxValRow(int[][] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        for (int[] row : arr) {
            int max = Integer.MIN_VALUE;
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
            result[i++] = max;
        }
        return result;
    }
    /**
     * Finds the maximum value in each column of a 2D array.
     *
     * @param arr the 2D array to search
     * @return an array containing the maximum value in each column
     */
    public static int[] maxValCol(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[] result = new int[cols];
        for (int j = 0; j < cols; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            result[j] = max;
        }
        return result;
    }
    /**
     * Counts the total number of letters in a 2D array of strings.
     *
     * @param arr the 2D array of strings
     * @return the total number of letters
     */
    public static int countTotalLetters(String[][] arr) {
        int count = 0;
        for (String[] row : arr) {
            for (String word : row) {
                count += word.length();
            }
        }
        return count;
    }
    /**
     * Counts the total number of letters in a 2D array of strings, excluding spaces.
     *
     * @param arr The 2D array of strings.
     * @return The total number of letters without spaces.
     */
    public static int countTotalLettersWithoutSpaces(String[][] arr) {
        int count = 0;
        for (String[] row : arr) {
            for (String word : row) {
                count += word.replace(" ", "").length();
            }
        }
        return count;
    }
                            
}
