package src.medium.Array;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class ArrayExamples {
    //Declaration
    static double[] arrayNameDouble;
    //An array is a collection of similar types of data.
    //
    //For example, if we want to store the names of 100 people then we can create an array of the string type that can store 100 names.
    String[] array=new String[100];
    Integer[] arrayNameInteger;


    public static void main(String[] args) {
        // allocate memory
        arrayNameDouble=new double[10];

        //In Java, we can declare and allocate the memory of an array in one single statement. For example,
        Integer[] arrayNameInteger=new Integer[10];

        //declare and initialize and array
        int[] arrayName={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // declare an array
        int[] age=new int[5];
        // initialize array
        age[0]=12;
        age[1]=4;
        age[2]=5;

        //// access array elements
        //array[index]

        System.out.println("Accessing Elements of Array:");
        System.out.println("First Element: "+age[0]);
        System.out.println("Second Element: "+age[1]);
        System.out.println("Third Element: "+age[2]);
        System.out.println("Fourth Element: "+age[3]);
        System.out.println("Fifth Element: "+age[4]);

        // Using For Loop
        System.out.println("Using For Loop");
        for (int i=0; i<age.length; i++) {
            System.out.println("Element at index "+i+": "+age[i]);
        }

        // Using the for-each Loop
        System.out.println("Using the for-each Loop");
        for (int i : age) {
            System.out.println("Element: "+i);
        }

        //Compute Sum and Average of Array Elements
        int[] numbers={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum=0;
        for (int i=0; i<numbers.length; i++) {
            sum+=numbers[i];
        }
        double average=sum/numbers.length;
        System.out.println("Sum = "+sum);
        System.out.println("Average = "+average);

        //Multidimensional Arrays

        //In Java, we can create multidimensional arrays. For example, we can create a two-dimensional array that can store 10 rows and 30 columns.
        double[][] arrayDouble=new double[10][30];

        double[][] matrix={{1.2, 4.3, 4.0},
                {4.1, -1.1}
        };

    }


}
