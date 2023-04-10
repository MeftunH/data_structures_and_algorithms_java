package src.ds.Backtracking;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.Arrays;

public class BinaryStrings {
    int[] A;

    public BinaryStrings(int n) {
        A=new int[n];
    }

    public void binary(int n) {
        if (n<=0) {
            System.out.println(Arrays.toString(A));
        } else {
            A[n-1]=0;
            binary(n-1);
            A[n-1]=1;
            binary(n-1);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        int n=4;
        BinaryStrings i=new BinaryStrings(n);
        i.binary(n);
    }
}
