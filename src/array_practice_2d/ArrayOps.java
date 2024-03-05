package array_practice_2d;

/**
 * The ArrayOps class provides methods for working with arrays.
 */
public class ArrayOps {
    /**
     * Creates a 3D array with the specified dimensions.
     *
     * @param a The length of the first dimension.
     * @param b The length of the second dimension.
     * @param c The length of the third dimension.
     * @return The created 3D array.
     */
    public static int[][][] create3DArray(int a, int b, int c) {
        int[][][] array = new int[a][b][c];
        return array;
    }
        
    /**
     * Calculates the sum of the first and last rows of a 2D array.
     *
     * @param array The 2D array.
     * @return The sum of the first and last rows.
     */
    public static double sumFirstAndLastRows(double[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        double sumFirstRow = 0;
        double sumLastRow = 0;

        for (int i = 0; i < cols; i++) {
            sumFirstRow += array[0][i];
            sumLastRow += array[rows - 1][i];
        }

        return sumFirstRow + sumLastRow;
    }
        
    /**
     * Calculates the sum of the first and last elements of a 2D array.
     *
     * @param array The 2D array.
     * @return The sum of the first and last elements.
     */
    public static int sumFirstAndLast(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        int sum = array[0][0] + array[rows - 1][cols - 1];
        return sum;
    }
        
    /**
     * Changes the values of the first and last elements of a 2D array to -100.
     *
     * @param array The 2D array.
     */
    public static void changeElements(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        array[0][0] = -100;
        array[rows - 1][cols - 1] = -100;
    }
}
