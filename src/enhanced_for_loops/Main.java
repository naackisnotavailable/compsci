package enhanced_for_loops;

public class Main {
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
    public static int countTotalLetters(String[][] arr) {
        int count = 0;
        for (String[] row : arr) {
            for (String word : row) {
                count += word.length();
            }
        }
        return count;
    }
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
