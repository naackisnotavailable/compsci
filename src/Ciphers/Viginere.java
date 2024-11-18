package Ciphers;


public class Viginere {
    /**
     * Applies the Vigenere cipher to the given original string using the provided keyword.
     * 
     * @param original the original string to be encrypted or decrypted
     * @param keyword the keyword used for encryption or decryption
     * @param encrypt true if the original string should be encrypted, false if it should be decrypted
     * @return the resulting string after applying the Vigenere cipher
     */
    public static String vigenereCipher(String original, String keyword, boolean encrypt){
        keyword = Utility.removeNonAlpha(keyword);
        keyword = Utility.toUpper(keyword);
        char[] cArr = original.toCharArray();
        char[] kArr = keyword.toCharArray();
        if(encrypt) {
            for (int i = 0; i < cArr.length; i++) {
                if (Character.isAlphabetic(cArr[i])) {
                    cArr[i] = Caesar.shiftAlphaCharacter(cArr[i], Utility.charToInt(kArr[i % (kArr.length)]) - 65);
                }
            }
        }else{
            for (int i = 0; i < cArr.length; i++) {
                if (Character.isAlphabetic(cArr[i])) {
                    cArr[i] = Caesar.shiftAlphaCharacter(cArr[i], -Utility.charToInt(kArr[i % (kArr.length)]) - 65);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char c: cArr){
            sb.append(c);
        }
        return sb.toString();

    }
}
