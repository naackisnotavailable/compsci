package Ciphers;

import java.util.Arrays;

public class Polybius {

    /**
     * Fills the given grid with characters from the provided content string.
     *
     * @param grid    the grid to be filled with characters
     * @param content the string containing the characters to be filled in the grid
     */
    public static void fillGrid(char[] grid, String content) {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = content.charAt(i);
        }
    }

    /**
     * Mixes the given key with the uppercase letters from 'A' to 'Z' and the digits from '0' to '9'.
     * Returns the mixed key as a string.
     *
     * @param key the original key to be mixed
     * @return the mixed key as a string
     */
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

    /**
     * Finds the position of a character in a grid.
     *
     * @param grid the grid of characters
     * @param c the character to find
     * @return the position of the character in the grid as a string in the format "rowcolumn"
     */
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

    /**
     * Finds the character in the grid based on the given row and column numbers.
     * 
     * @param grid The grid containing characters.
     * @param rowColumn The row and column numbers in the format "RC", where R is the row number and C is the column number.
     * @return The character found in the grid at the specified row and column.
     */
    public static char findInGridNum(char[] grid, String rowColumn) {
        char[] cArr = rowColumn.toCharArray();
        int row = (int) cArr[0] - 48;
        int column = (int) cArr[1] - 48;
        int pos = row * 6 + column;
        return grid[pos];
    }



    /**
     * Encrypts or decrypts a given string using the Polybius Square cipher.
     *
     * @param grid      The character grid used for encryption or decryption.
     * @param key       The key used to mix the character grid.
     * @param original  The original string to be encrypted or decrypted.
     * @param encrypt   A boolean value indicating whether to encrypt or decrypt the string.
     * @return          The encrypted or decrypted string.
     */
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
