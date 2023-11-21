package IntroToArrayPractice11_20_2023;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Main {
    int[] pi = new int[]{3, 1, 4};  //1

    public double multiply(double[] nums){ //2
        return nums[0]*nums[1];
    }

    public double sum(double[] nums){ //3
        double sum = 0;
        for(double x: nums){
            sum+=x;
        }
        return sum;
    }

    public boolean checkFirst(double[] arr1, double[] arr2){ //4
        return arr1[0] == arr2[0];
    }

    public double[] firstLast(double[] arr){ //5
        return new double[]{arr[0], arr[1]};
    }

    public double[] combineMiddle(double[] arr1, double[] arr2){ //6
        return new double[]{arr1[1], arr2[1]};
    }

    public static double[] getMiddles(double[] arr1, double[] arr2){ //7
        int middle1 = (int) Math.floor(arr1.length/2);
        int middle2 = (int) Math.floor(arr2.length/2);
        return new double[]{arr1[middle1], arr2[middle2]};
    }

    public static double[] getMiddle(double[] arr){ //8
        int middle = (int) Math.floor(arr.length/2);
        return new double[]{arr[middle-1], arr[middle]};
    }

    public static boolean has2(double[] arr){ //9
        for(double x: arr){
            if(x==2){
                return true;
            }
        }
        return false;
    }

    public static double[] keepLast(double[] arr){ //10
        double[] arr1 = new double[arr.length];
        for(int i=0; i<arr.length-1; i++){
            arr1[i]=4;
        }
        arr1[arr.length-1] = arr[arr.length-1];
        return arr1;
    }

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

    public static double[] addRespective(double[] a, double[] b){ //12
        return new double[]{a[0]+b[0], a[1]+b[1]};
    }

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
