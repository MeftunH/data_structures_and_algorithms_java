package src;

import java.util.HashSet;
import java.util.Set;

public class SetDataStructure {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("example");
        set.add("example2");
        set.add("example3");
        set.add("example4");

        //contains method is o(1) time
        //contains chekc if the element is in the set. It does not check if the element is in the list.
        set.add("example2");

        set.forEach(s-> System.out.println(s));
    }

}
