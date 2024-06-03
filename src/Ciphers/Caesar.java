package Ciphers;

import java.util.Arrays;

public class Caesar {
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
