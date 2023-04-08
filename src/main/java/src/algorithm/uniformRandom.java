package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class uniformRandom {
    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes=upperBound-lowerBound+1, result;
        do {
            result= 0;
            for (int i= 0;
            (1<<i) <numberOfOutcomes;
            ++i){
// zeroOneRandom() is the provided random number generator.
                result=(result<<1)|zeroOneRandom();
            }
        } while (result>=numberOfOutcomes);
        return result+lowerBound;
    }

    private static int zeroOneRandom() {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(uniformRandom(1, 5));
    }
}
