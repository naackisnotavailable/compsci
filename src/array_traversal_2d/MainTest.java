package array_traversal_2d;
import java.util.Arrays;


/**
 * This class contains test methods for the Main class.
 */
class MainTest {
    void testAlternating10() {
        int[][] expected = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                expected[i][j] = (i + j) % 2;
            }
        }

        int[][] actual = Main.alternating10();
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println("testAlternating10 passed");
        } else {
            System.out.println("testAlternating10 failed");
        }
    }

    void testMultiplicationTable() {
        int[][] expected = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                expected[i][j] = (i + 1) * (j + 1);
            }
        }

        int[][] actual = Main.multiplicationTable();
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println("testMultiplicationTable passed");
        } else {
            System.out.println("testMultiplicationTable failed");
        }
    }

    void testSquareMatrix() {
        int[][] expected = new int[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (i >= j) {
                    expected[i][j] = 1;
                } else {
                    expected[i][j] = 0;
                }
            }
        }

        int[][] actual = Main.squareMatrix();
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println("testSquareMatrix passed");
        } else {
            System.out.println("testSquareMatrix failed");
        }
    }

    void testRand15x3() {
        double[][] actual = Main.rand15x3();
        boolean passed = true;
        if (actual.length != 15 || actual[0].length != 3) {
            passed = false;
        } else {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 3; j++) {
                    if (actual[i][j] < 4 || actual[i][j] > 16) {
                        passed = false;
                        break;
                    }
                }
            }
        }
        if (passed) {
            System.out.println("testRand15x3 passed");
        } else {
            System.out.println("testRand15x3 failed");
        }
    }

    void testRowSum() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected = {6, 15, 24};

        int[] actual = Main.rowSum(array);
        if (Arrays.equals(expected, actual)) {
            System.out.println("testRowSum passed");
        } else {
            System.out.println("testRowSum failed");
        }
    }

    void testColSum() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected = {12, 15, 18};

        int[] actual = Main.colSum(array);
        if (Arrays.equals(expected, actual)) {
            System.out.println("testColSum passed");
        } else {
            System.out.println("testColSum failed");
        }
    }

    void testTranspose() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        int[][] actual = Main.transpose(array);
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println("testTranspose passed");
        } else {
            System.out.println("testTranspose failed");
        }
    }

    void testContainsElement() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        boolean contains5 = Main.containsElement(array, 5);
        boolean contains10 = Main.containsElement(array, 10);
        if (contains5 && !contains10) {
            System.out.println("testContainsElement passed");
        } else {
            System.out.println("testContainsElement failed");
        }
    }
}