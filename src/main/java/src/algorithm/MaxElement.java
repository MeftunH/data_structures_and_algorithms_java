package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class MaxElement {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25};
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum Element: " + max);
    }
}
