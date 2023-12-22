package Ciphers;

import java.util.Arrays;

public class Polybius {

    public static void fillGrid(char[] grid, String content) {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = content.charAt(i);
        }
    }

    public static String mixKey(String key) {
        StringBuilder mixedKey = new StringBuilder(key);

        for (char c = 'A'; c <= 'Z'; c++) {
            if (key.indexOf(c) == -1) {
                mixedKey.append(c);
            }
        }

        for (char c = '0'; c <= '9'; c++) {
            if (key.indexOf(c) == -1) {
                mixedKey.append(c);
            }
        }

        return mixedKey.toString();
    }

    public static String findInGrid(char[] grid, char c) {
        int column = 0;
        int row = 0;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == c) {
                column = i % 6;
                row = i / 6;
            }
        }
        return String.format("%d%d", row, column);
    }

    public static char findInGridNum(char[] grid, String rowColumn) {
        char[] cArr = rowColumn.toCharArray();
        int row = (int) cArr[0] - 48;
        int column = (int) cArr[1] - 48;
        int pos = row * 6 + column;
        return grid[pos];
    }



    public static String polybiusSquare(char[] grid, String key, String original, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        char[] cArr = original.toCharArray();
        String[] positions = new String[cArr.length];
        char[] positions2 = new char[cArr.length];
        char[] chars = new char[cArr.length];
        char[] mixedGrid = Arrays.copyOf(grid, grid.length);
        String mixedKey = mixKey(key);
        fillGrid(mixedGrid, mixedKey);
        if (encrypt) {
            for (int i = 0; i < cArr.length; i++) {
                positions[i] = findInGrid(grid, cArr[i]);
            }

            for (int i = 0; i < positions.length; i++) {
                chars[i] = findInGridNum(mixedGrid, positions[i]);
            }
            for (char c : chars) {
                result.append(c);
            }
        } else {
            for (int i = 0; i < cArr.length; i++) {
                positions[i] = findInGrid(mixedGrid, cArr[i]);
            }

            for (int i = 0; i < positions.length; i++) {
                chars[i] = findInGridNum(grid, positions[i]);
            }
            for (char c : chars) {
                result.append(c);
            }


        }
        return result.toString();

    }
}
