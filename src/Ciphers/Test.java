package Ciphers;

import jdk.jshell.execution.Util;

public class Test {
    public static void main(String[] args) {

        char[] grid = new char[36];
        Polybius.fillGrid(grid, Utility.ALNUM);

        String plaintext = "ABCS";
        String encryptedText = Polybius.polybiusSquare(grid, "ZXY", plaintext, true);

        String decryptedText = Polybius.polybiusSquare(grid, "ZXY", encryptedText, false);
        System.out.println(encryptedText);
        System.out.println(decryptedText);

        Utility.printGrid(grid);

        System.out.println(Utility.charToInt('c'));

        System.out.println(Utility.removeDuplicate("aabc"));

        System.out.println(Utility.removeNonAlpha("he11o!"));

        System.out.println(Utility.toUpper("hEllO!"));

        String encrypted = Viginere.vigenereCipher("hello", "hi", true);
        System.out.println(Viginere.vigenereCipher(encrypted, "hi", false));

        System.out.println(Caesar.shiftAlphaCharacter('c', 4));
        encrypted = Caesar.caesarCipher("hi", 9, true);
        System.out.println(Caesar.caesarCipher(encrypted, 9, false));


    }
}
