package array_traversal_2d;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] array = alternating10();
        printArray(array);

    }
    public static int[][] alternating10() {
        int[][] array = new int[100][100];
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                array[i][j] = (i + j) % 2;
            }
        }
        
    return array;
    }

    public static int[][] multiplicationTable() {
        int[][] array = new int[20][20];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        
    return array;
    }

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
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}


