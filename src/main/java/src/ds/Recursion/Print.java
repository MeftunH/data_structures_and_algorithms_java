package src.ds.Recursion;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class Print {
    public int Print(int n) {
        if (n==0) // this is the terminating base case
            return 0;
        else {
            System.out.println(n);
            return Print(n-1); // recursive call to itself again
        }
    }

}
