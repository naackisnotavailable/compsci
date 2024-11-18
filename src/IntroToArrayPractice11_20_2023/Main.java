package IntroToArrayPractice11_20_2023;

import java.util.Arrays;

public class Main {
    int[] pi = new int[]{3, 1, 4};  //1

    /**
     * Multiplies two numbers.
     * 
     * @param nums an array of two numbers to be multiplied
     * @return the product of the two numbers
     */
    public double multiply(double[] nums){ //2
        return nums[0]*nums[1];
    }

    /**
     * Calculates the sum of all elements in the given array.
     *
     * @param nums the array of numbers
     * @return the sum of all elements in the array
     */
    public double sum(double[] nums){ //3
        double sum = 0;
        for(double x: nums){
            sum+=x;
        }
        return sum;
    }

    /**
     * Checks if the first elements of two double arrays are equal.
     * 
     * @param arr1 the first double array
     * @param arr2 the second double array
     * @return true if the first elements of the arrays are equal, false otherwise
     */
    public boolean checkFirst(double[] arr1, double[] arr2){ //4
        return arr1[0] == arr2[0];
    }

    /**
     * Returns a new array containing the first two elements of the given array.
     *
     * @param arr the input array
     * @return a new array containing the first two elements of the input array
     */
    public double[] firstLast(double[] arr){ //5
        return new double[]{arr[0], arr[1]};
    }

    /**
     * Combines the middle elements of two arrays into a new array.
     * The middle elements are determined by the index 1 of each array.
     *
     * @param arr1 the first array
     * @param arr2 the second array
     * @return a new array containing the middle elements of arr1 and arr2
     */
    public double[] combineMiddle(double[] arr1, double[] arr2){ //6
        return new double[]{arr1[1], arr2[1]};
    }

    /**
     * Returns an array containing the middle elements of two input arrays.
     *
     * @param arr1 the first input array
     * @param arr2 the second input array
     * @return an array containing the middle elements of arr1 and arr2
     */
    public static double[] getMiddles(double[] arr1, double[] arr2){ //7
        int middle1 = (int) Math.floor(arr1.length/2);
        int middle2 = (int) Math.floor(arr2.length/2);
        return new double[]{arr1[middle1], arr2[middle2]};
    }

    /**
     * Returns an array containing the middle two elements of the given array.
     *
     * @param arr the input array
     * @return an array containing the middle two elements
     */
    public static double[] getMiddle(double[] arr){ //8
        int middle = (int) Math.floor(arr.length/2);
        return new double[]{arr[middle-1], arr[middle]};
    }

    /**
     * Checks if the given array contains the value 2.
     *
     * @param arr the array to be checked
     * @return true if the array contains the value 2, false otherwise
     */
    public static boolean has2(double[] arr){ //9
        for(double x: arr){
            if(x==2){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a new array where the last element is preserved and all other elements are replaced with 4.
     *
     * @param arr the input array
     * @return a new array with the last element preserved and all other elements replaced with 4
     */
    public static double[] keepLast(double[] arr){ //10
        double[] arr1 = new double[arr.length];
        for(int i=0; i<arr.length-1; i++){
            arr1[i]=4;
        }
        arr1[arr.length-1] = arr[arr.length-1];
        return arr1;
    }

    /**
     * Compares the sums of two integer arrays and returns the array with the greater sum.
     * If the sums are equal, it returns the first array.
     *
     * @param a the first integer array
     * @param b the second integer array
     * @return the array with the greater sum, or the first array if the sums are equal
     */
    public static int[] compareSums(int[] a, int[] b){ //11
        int sum1 = 0;
        int sum2 = 0;
        for(int x: a){
            sum1+=x;
        }
        for(int x: b){
            sum2+=x;
        }
        if(sum1>sum2){
            return a;
        }else if(sum2>sum1){
            return b;
        }
        return a;
    }

    /**
     * Adds the respective elements of two arrays and returns a new array with the sum.
     *
     * @param a the first array
     * @param b the second array
     * @return a new array containing the sum of the respective elements of a and b
     */
    public static double[] addRespective(double[] a, double[] b){ //12
        return new double[]{a[0]+b[0], a[1]+b[1]};
    }

    /**
     * Returns an array containing the first indexes of two input arrays.
     * If either of the input arrays is empty, the first index of the non-empty array is returned.
     * If both input arrays are empty, an empty array is returned.
     *
     * @param c the first input array
     * @param b the second input array
     * @return an array containing the first indexes of the input arrays
     */
    public static int[] firstIndexes(int[] c, int[] b){
        if(c.length==0){
            return new int[]{b[0]};
        }
        if(b.length==0){
            return new int[]{c[0]};
        }
        return new int[]{c[0], b[0]};
    }
    public static void main(String[] args) {
        System.out.println((Arrays.toString(getMiddles(new double[]{0, 1, 2}, new double[]{1, 5, 7, 9, 11, 13, 15}))));
        System.out.println(Arrays.toString(getMiddle(new double[]{0, 1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(keepLast(new double[]{1, 2, 4, 6, 7})));


    }
}
