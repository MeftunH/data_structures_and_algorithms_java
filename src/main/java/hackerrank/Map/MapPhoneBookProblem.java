package hackerrank.Map;

import java.util.HashMap;
import java.util.Scanner;

public class MapPhoneBookProblem {
    public static void main(String[] args) {
        HashMap<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String query = in.nextLine();
            Integer phone = phoneBook.get(query);
            String result = phone == null ? "Not found" : query + "=" + phone;
            if (phone == null) {
              result = "Not found";
            } else {
              result +=  "=" + phone;
            }
            System.out.println( result);
        }
    }
}
