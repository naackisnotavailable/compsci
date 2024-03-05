package Ciphers;

public class Utility {
        public final static String ALNUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Returns the index of the first occurrence of the specified character in the given character array.
     *
     * @param c the character array to search in
     * @param n the character to search for
     * @return the index of the first occurrence of the character, or -1 if the character is not found
     */
    public static int indexOf(char[] c, char n){
        int count = 0;
        for(char i: c){
            if(i == n){
                return count;
            }
            count +=1;
        }
        return -1;
    }

        /**
         * Converts a string to uppercase.
         *
         * @param original the original string to be converted
         * @return the converted string in uppercase
         */
        public static String toUpper(String original) {
            StringBuilder sb = new StringBuilder();
            for(char c: original.toCharArray()) {
                sb.append(Character.toUpperCase(c));
            }
            return sb.toString();}

        /**
         * Removes all non-alphabetic characters from the given string.
         * 
         * @param original the original string
         * @return the modified string with only alphabetic characters
         */
        public static String removeNonAlpha(String original){
            StringBuilder sb = new StringBuilder();
            for(char c: original.toCharArray()) {
                if(Character.isAlphabetic(c)) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        /**
         * Removes duplicate characters from a given string.
         *
         * @param original the original string
         * @return a new string with duplicate characters removed
         */
        public static String removeDuplicate(String original){
            char[] cArr = original.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c: cArr){
                if(sb.indexOf(String.valueOf(c))==-1){
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        /**
         * Converts a character to its corresponding integer value.
         *
         * @param original the character to be converted
         * @return the integer value of the character
         */
        public static int charToInt (char original){
            return (int) original;
        }

        /**
         * Prints a grid of characters.
         * 
         * @param grid the array of characters representing the grid
         */
        public static void printGrid(char[] grid){
            for (int j = 0; j < 6; j++){
                System.out.print(" ---");
            }
            System.out.println();
            for (int i = 0; i < 6; i++){
                System.out.print("| ");
                for (int j = 0; j < 6; j++){
                    System.out.print(grid[j + (i*6)] + " | ");
                }
                System.out.println();
                for (int j = 0; j < 6; j++){
                    System.out.print(" ---");
                }
                System.out.println();
            }
        }
    }
