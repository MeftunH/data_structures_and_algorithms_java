package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class dutchFlagPartition {

    static int i, j;
    static void dutchFlagPartition(int a[], int l, int r)
    {

        i = l - 1; j = r;
        int p = l - 1, q = r;
        int v = a[r];

        while (true)
        {

            // From left, find the first element greater than
            // or equal to v. This loop will definitely
            // terminate as v is last element
            while (a[++i] < v)
                ;

            // From right, find the first element smaller than
            // or equal to v
            while (v < a[--j])
                if (j == l)
                    break;

            // If i and j cross, then we are done
            if (i >= j)
                break;

            // Swap, so that smaller goes on left greater goes
            // on right
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            // Move all same left occurrence of pivot to
            // beginning of array and keep count using p
            if (a[i] == v) {
                p++;
                temp = a[i];
                a[i] = a[p];
                a[p] = temp;

            }

            // Move all same right occurrence of pivot to end of
            // array and keep count using q
            if (a[j] == v) {
                q--;
                temp = a[q];
                a[q] = a[j];
                a[j] = temp;
            }
        }

        // Move pivot element to its correct index
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;

        // Move all left same occurrences from beginning
        // to adjacent to arr[i]
        j = i - 1;
        for (int k = l; k < p; k++, j--)
        {
            temp = a[k];
            a[k] = a[j];
            a[j] = temp;
        }

        // Move all right same occurrences from end
        // to adjacent to arr[i]
        i = i + 1;
        for (int k = r - 1; k > q; k--, i++)
        {
            temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }
    }

    // 3-way partition based quick sort
    static void quicksort(int a[], int l, int r)
    {
        if (r <= l)
            return;

        i = 0; j = 0;

        // Note that i and j are passed as reference
        dutchFlagPartition(a, l, r);

        // Recur
        quicksort(a, l, j);
        quicksort(a, i, r);
    }

    // A utility function to print an array
    static void printarr(int a[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.printf("%d  ", a[i]);
        System.out.printf("\n");
    }

    // Driver code
    public static void main(String[] args)
    {
        int a[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
        int size = a.length;

        // Function Call
        printarr(a, size);
        quicksort(a, 0, size - 1);
        printarr(a, size);
    }
}
