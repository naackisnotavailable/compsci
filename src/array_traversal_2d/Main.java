package array_traversal_2d;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] array = alternating10();
        printArray(array);

    }
    /**
     * Generates a 2D array filled with alternating 1s and 0s.
     *
     * @return The generated 2D array.
     */
    public static int[][] alternating10() {
        int[][] array = new int[100][100];
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                array[i][j] = (i + j) % 2;
            }
        }
        
    return array;
    }

    /**
     * Generates a multiplication table as a 2D array.
     *
     * @return The multiplication table as a 2D array.
     */
    public static int[][] multiplicationTable() {
        int[][] array = new int[20][20];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        
    return array;
    }

    /**
     * Generates a square matrix with dimensions 30x30.
     * The upper triangular part of the matrix contains 1s, while the lower triangular part contains 0s.
     *
     * @return the generated square matrix
     */
    public static int[][] squareMatrix() {
        int[][] matrix = new int[30][30];
        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (i >= j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        
    return matrix;
    }

    /**
     * Generates a 15x3 array of random double values between 4 and 16.
     *
     * @return the generated array
     */
    public static double[][] rand15x3() {
        Random rand = new Random();
        double[][] array = new double[15][3];
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = 4 + rand.nextDouble() * (16 - 4);
            }
        }
    return array;
    }
    /**
     * Calculates the sum of each row in a 2D array and returns an array containing the row sums.
     *
     * @param array the 2D array to calculate row sums for
     * @return an array containing the sum of each row in the input array
     */
    public static int[] rowSum(int[][] array) {
    int[] rowSums = new int[array.length];
    
    for (int i = 0; i < array.length; i++) {
        int sum = 0;
        for (int j = 0; j < array[i].length; j++) {
            sum += array[i][j];
        }
        rowSums[i] = sum;
    }
    
    return rowSums;  
    }
    /**
     * Calculates the sum of each column in a 2D array.
     *
     * @param array the 2D array to calculate column sums for
     * @return an array containing the sum of each column in the input array
     */
    public static int[] colSum(int[][] array) {
    int[] colSums = new int[array[0].length];
    
    for (int i = 0; i < array[0].length; i++) {
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum += array[j][i];
        }
        colSums[i] = sum;
    }
    
    return colSums;
    }

    /**
     * Transposes a 2D array.
     *
     * @param array the 2D array to be transposed
     * @return the transposed 2D array
     */
    public static int[][] transpose(int[][] array) {
    int rows = array.length;
    int cols = array[0].length;
    int[][] transposedArray = new int[cols][rows];
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            transposedArray[j][i] = array[i][j];
        }
    }
    
    return transposedArray;
    }

    /**
     * Checks if the given 2D array contains the specified element.
     *
     * @param array   the 2D array to be searched
     * @param element the element to be checked for existence
     * @return true if the element is found in the array, false otherwise
     */
    public static boolean containsElement(int[][] array, int element) {
    for (int[] row : array) {
        for (int num : row) {
            if (num == element) {
                return true;
            }
        }
    }
    return false;
    }
    /**
     * Prints the elements of a 2D array.
     *
     * @param array The 2D array to be printed.
     */
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}


