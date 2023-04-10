package src.ds.Recursion;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class Factorial {
    public static void main(String[] args) {
        Factorial obj=new Factorial();
        for (int counter=0; counter<=10; counter++)
            System.out.printf("%d! = %d\n", counter, obj.factorial(counter));
    }

    // recursive definition of method factorial
    public long factorial(long number) {
        if (number<=1) // test for base case
            return 1; // base cases: 0! = 1 and 1! = 1
        else
            // recursion step
            return number*factorial(number-1);
    }
}