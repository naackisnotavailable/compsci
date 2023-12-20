package Ciphers;


public class Viginere {
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
