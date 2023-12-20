package Ciphers;

public class Polybius {
    static char[] grid = new char[36];

    public static void fillGrid(char[] grid, String content){
        char[] cArr = content.toCharArray();
        System.arraycopy(cArr, 0, grid, 0, cArr.length);
    }

    public static String mixKey(char[] grid, String key){
        StringBuilder sb = new StringBuilder();
        for(char c: grid) {
            sb.append(c);
        }
        String gridString = sb.toString();

        key=key.concat(gridString);
        key=Utility.removeDuplicate(key);
        return key;

    }

    public static int findInGrid(char[] grid, char c){
        int column =0;
        int row = 0;

        for(int i=0; i<grid.length; i++){
            if(grid[i]==c){
                column = i%6 +1;
                row = i/6 +1;
            }
        }
        return row*10 + column;
    }

    public static int findNumInGrid(char[] grid, char c){

        for(int i=0; i<grid.length; i++){
            if(grid[i]==c){
                return i;
            }
            }
        return -1;
        }

    public static String polybiusSquare(char[] grid, String key, String original, boolean encrypt){
        StringBuilder result = new StringBuilder();
        String mixedGrid = mixKey(grid, key);
        char[] oArr = original.toCharArray();
        int[] oIArr = new int[36];
        for(int i=0; i<oArr.length; i++){
            oIArr[i] = findInGrid(grid, oArr[i]);
        }
        if(encrypt){
            for(int x: oIArr){
                result.append(grid[x]);
            }
        }
        return result.toString();
    }
    public static void printGrid(){
        Utility.printGrid(grid);
    }
}
