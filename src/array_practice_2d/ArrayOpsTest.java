package array_practice_2d;

public class ArrayOpsTest {
    public static void main(String[] args) {
        testCreate3DArray();
        testSumFirstAndLastRows();
        testSumFirstAndLast();
        testChangeElements();
    }

    public static void testCreate3DArray() {
        int[][][] array = ArrayOps.create3DArray(2, 3, 4);
        System.out.println("3D Array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void testSumFirstAndLastRows() {
        double[][] array = {
            {1.5, 2.5, 3.5},
            {4.5, 5.5, 6.5},
            {7.5, 8.5, 9.5}
        };

        double sum = ArrayOps.sumFirstAndLastRows(array);
        System.out.println("Sum of first and last rows: " + sum);
    }

    public static void testSumFirstAndLast() {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int sum = ArrayOps.sumFirstAndLast(array);
        System.out.println("Sum of first and last elements: " + sum);
    }

    public static void testChangeElements() {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Before changing elements:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        ArrayOps.changeElements(array);

        System.out.println("After changing elements:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}