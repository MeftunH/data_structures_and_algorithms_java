package hackerrank.Set;

import java.util.Formattable;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueHashSetProblem {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int t=s.nextInt();
        String [] pair_left=new String[t];
        String [] pair_right=new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        Set<String> set = new HashSet<>();
        int count = 0;
        //john tom
        for (int i = 0; i < t; i++) {
           String pair = pair_left[i]+" "+pair_right[i];
            System.out.println(set.size());
            if (set.add(pair))
            {
                count++;
                System.out.println(count);
            }
        }
    }
}
