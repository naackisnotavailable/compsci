package Homework612_5_2023;

import java.util.Arrays;

public class Main {
    /**
     * Shifts the elements of the given array by the specified amount.
     * 
     * @param arr the array to be shifted
     * @param shift the amount by which the elements should be shifted
     * @return a new array with the shifted elements
     */
    public static int[] shiftArr(int[] arr, int shift){ //1
        int[] newArr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
                newArr[i] = arr[(i+shift)%arr.length];
        }
        return newArr;
    }
    /**
     * Checks if the elements in the given array are in ascending order.
     * 
     * @param arr the array to be checked
     * @return true if the elements are in ascending order, false otherwise
     */
    public static boolean checkOrder(int[] arr){ //2
        int x_last = arr[0];
        for(int i=1; i<arr.length; i++){
            if(x_last>=arr[i]){
                return false;
            }
            x_last = arr[i];
        }
        return true;
    }
    /**
     * Counts the number of strings in an array that have a specified length.
     *
     * @param strs the array of strings to be counted
     * @param len the length of strings to be counted
     * @return the number of strings in the array that have the specified length
     */
    public static int countStrings(String[] strs, int len){ //3
        int count = 0;
        for(String str: strs){
            if(str.length()==len){
                count+=1;
            }
        }
        return count;
    }
    /**
     * Compares two arrays of strings and counts the number of strings that have the same length and the same first character.
     * 
     * @param arr1 the first array of strings
     * @param arr2 the second array of strings
     * @return the count of strings that meet the specified criteria
     */
    public static int compareStrings(String[] arr1, String[] arr2){ //4
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i].length()==arr2[i].length() && arr1[i].charAt(0) == arr2[i].charAt(0)){
                count=+1;
            }
        }
        return count;
    }


    public static void main(String[] args){
        System.out.println(Arrays.toString(shiftArr(new int[]{1, 2, 3, 4}, 1)));
        System.out.println(checkOrder(new int[]{1, 2, 3, 4, 3}));
        System.out.println(countStrings(new String[]{"abc", "defg", "hi", "jkl"}, 3));
        System.out.println(compareStrings(new String[]{"abc", "efgc", "bb"}, new String[]{"acb", "efg", "bbb"}));
        Sound sound = new Sound(new int[]{0, 0, 0, 0, 0, -1, -10, -15, -5, 1, 2, 3, 5, 10, 15, 20});
        sound.limitAmplitude(10);
        System.out.println(Arrays.toString(sound.getSamples()));
        sound.trimSilenceFromBeginning();
        System.out.println(Arrays.toString(sound.getSamples()));

    }
}
