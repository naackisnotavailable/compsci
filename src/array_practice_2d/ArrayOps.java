package array_practice_2d;

public class ArrayOps {
    public static int[][][] create3DArray(int a, int b, int c) {
        int[][][] array = new int[a][b][c];
        return array;
    }
        
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
        
    public static int sumFirstAndLast(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        int sum = array[0][0] + array[rows - 1][cols - 1];
        return sum;
    }
        
    public static void changeElements(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        array[0][0] = -100;
        array[rows - 1][cols - 1] = -100;
    }
    
}
