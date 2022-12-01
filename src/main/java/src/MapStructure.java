package src;

import java.util.TreeMap;

public class MapStructure {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        tm.put("John",21);
        tm.put("Tom",22);
        tm.put("Mike",23);
        tm.put("Jack",24);

        System.out.println(tm.get("John"));
        System.out.println(tm.firstKey());
        System.out.println(tm.lastEntry());
    }
}
