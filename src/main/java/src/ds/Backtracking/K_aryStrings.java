package src.ds.Backtracking;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.Arrays;

class K_aryStrings {
    int[] A;

    public K_aryStrings(int n) {
        A=new int[n];
    }

    public static void main(String[] args) throws java.lang.Exception {
        int n=4;
        K_aryStrings obj=new K_aryStrings(n);
        obj.base_K_strings(n, 3);
    }

    public void base_K_strings(int n, int k) {
        //process all k-ary strings of length m
        if (n<=0)
            System.out.println(Arrays.toString(A)); //Assume array A is a class variable
        else {
            for (int j=0; j<k; j++) {
                A[n-1]=j;
                base_K_strings(n-1, k);
            }
        }
    }
}

