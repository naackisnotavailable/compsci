package Ciphers;

import java.util.Arrays;

public class Caesar {
    /**
     * Shifts an alphabetic character by a given number of positions.
     * 
     * @param c the character to be shifted
     * @param n the number of positions to shift the character by
     * @return the shifted character
     */
    public static char shiftAlphaCharacter(char c, int n){
        boolean lowercase = false;
        int result =0;
        if((int) c >90){
            lowercase = true;
        }
        if(lowercase){
            int dig = (int) c -97;
            if(n<0){
                result = ((((dig+n) % 26) + 26) % 26);
            }else {
                result = (dig + n) % 26;
            }
            result+=97;
        }else{
            int dig = (int) c -65;
            if(n<0){
                result = ((((dig+n) % 26) + 26) % 26);
            }else {
                result = (dig + n) % 26;
            }
            result+=65;
        }
        return (char) (result);
    }
    /**
     * Applies the Caesar cipher to the given string.
     *
     * @param original the original string to be encrypted or decrypted
     * @param key the key used for encryption or decryption
     * @param encrypt a boolean value indicating whether to encrypt or decrypt the string
     * @return the resulting string after applying the Caesar cipher
     */
    public static String caesarCipher(String original, int key, boolean encrypt){
        char[] cArr = original.toCharArray();
        if(!encrypt){
            key=-key;
        }
        for(int i=0; i<cArr.length; i++){
            if(Character.isAlphabetic(cArr[i])){
                cArr[i]=shiftAlphaCharacter(cArr[i], key);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: cArr){
            sb.append(c);
        }
        return sb.toString();

    }


}
