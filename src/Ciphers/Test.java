package Ciphers;

public class Test {
    public static void main(String[] args) {
        String tester = "hello!1";
        System.out.println(Utility.toUpper(tester));
        System.out.println(Utility.removeNonAlpha(tester));
        System.out.println(Utility.removeDuplicate(tester));
        char[] grid = new char[36];
        Polybius.fillGrid(grid, Utility.ALNUM);

        System.out.println(Polybius.polybiusSquare(grid, "HI", "HELLO", true));
    }

}
