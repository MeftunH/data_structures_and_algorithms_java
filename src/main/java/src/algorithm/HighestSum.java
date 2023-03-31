package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class HighestSum {
    public static int findHighestSum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(findHighestSum(arr));
    }
}
