package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListStructure {
    public static void main(String[] args) {
        //array is a static data structure. It has a fixed size.
        int array[] = new int[3];
        array[0] = 1;
        array[1] = array[0]; //o(1) notation constant time
        //[1] [] [1]

        ArrayList<Integer> arrayList = new ArrayList<Integer>(); //does not contain primitive types Integer is a wrapper class for int type.
        //ArrayList is a dynamic array, it can grow and shrink in size.
        // When array is full it creates a new array with double the size and copies all the elements from the old array to the new array.
        //ArrayList's one element points to the next element. It is a linear data structure. It is not good for insertion and deletion.
        //O(N) worst case insert
        //o(1) ON AVERAGE
        arrayList.add(1);
        arrayList.add(2);
        //it does array's job in o(1) time for each element.Finally it does the job of array in o(n) time.

        //M
        LinkedList<String> linkedList = new LinkedList<String>();

        //LinkedList's one element have 3 parts. It has a element's address, a pointer to the next element and a pointer to the previous element.

        //[prev element next] ----------> <----------[prev element next] ----------> <---------[prev element next]
        //It is a doubly linked list. It is not good for insertion and deletion. It is not good for searching.
        //Differnece from arraylist,we not to have double the size of the array. We just need to change the pointers.
        //we have only head's address. we can traverse the list from head to tail.
        //O(N) searhcing
        //o(!) insertion

        linkedList.add("example");
        if (linkedList.contains("example")) {
            System.out.println("example is in the list");
        }
        else {
            System.out.println("example is not in the list");
        }
    }

}
