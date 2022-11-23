package src;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        //array is a static data structure. It has a fixed size.
        int array[] = new int[3];
        array[0] = 1;
        array[1] = array[0]; //o(1) notation constant time
        //[1] [] [1]

        ArrayList<Integer> arrayList = new ArrayList<Integer>(); //does not contain primitive types Integer is a wrapper class for int type.
        //ArrayList is a dynamic array, it can grow and shrink in size.
        // When array is full it creates a new array with double the size and copies all the elements from the old array to the new array.
        arrayList.add(1);
        arrayList.add(2);
        //it does array's job in o(1) time for each element.Finally it does the job of array in o(n) time.
    }

}
