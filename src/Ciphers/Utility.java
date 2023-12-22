package Ciphers;

public class Utility {
        public final static String ALNUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

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

        public static String toUpper(String original) {
            StringBuilder sb = new StringBuilder();
            for(char c: original.toCharArray()) {
                sb.append(Character.toUpperCase(c));
            }
            return sb.toString();}

        public static String removeNonAlpha(String original){
            StringBuilder sb = new StringBuilder();
            for(char c: original.toCharArray()) {
                if(Character.isAlphabetic(c)) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

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

        public static int charToInt (char original){
            return (int) original;
        }

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
