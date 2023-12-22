package Ciphers;

import java.util.Scanner;

public class Cipher {
    public static void main(String[] args){
        String encryptString;
        boolean encrypt;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a cipher: ");
        String in = scanner.nextLine().toLowerCase();
        if(in.equals("polybius")) {
            System.out.println("Are you encrypting or decrypting?");
            in = scanner.nextLine();
            encrypt= in.equals("encrypting");
            System.out.println("Enter a message: ");
            encryptString=scanner.nextLine().toUpperCase();

            System.out.println("Enter key: ");
            String key = scanner.nextLine().toUpperCase();

            char[] grid = new char[36];
            Polybius.fillGrid(grid, Utility.ALNUM);

            String out = Polybius.polybiusSquare(grid, key, encryptString, encrypt);
            System.out.println(out);

        }
        if(in.equals("viginere")) {
            System.out.println("Are you encrypting or decrypting?");
            in = scanner.nextLine();
            encrypt= in.equals("encrypting");
            System.out.println("Enter a message: ");
            encryptString=scanner.nextLine();

            System.out.println("Enter key: ");
            String key = scanner.nextLine();

            String out = Viginere.vigenereCipher(encryptString, key, encrypt);
            System.out.println(out);
        }
        if(in.equals("caesar")) {
            System.out.println("Are you encrypting or decrypting?");
            in = scanner.nextLine();
            encrypt= in.equals("encrypting");
            System.out.println("Enter a message: ");
            encryptString=scanner.nextLine();

            System.out.println("Enter key: ");
            int key = scanner.nextInt();

            String out = Caesar.caesarCipher(encryptString, key, encrypt);
            System.out.println(out);

        }

    }
}
