package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.Deque;
import java.util.LinkedList;

public class Eval {
    public static int eval(String RPNExpression) {
        Deque<Integer> intermediateResults=new LinkedList<>();
        String delimiter=",";
        String[] symbols=RPNExpression.split(delimiter);
        for (String token : symbols) {
            if (token.length()==1) {
                final int y=intermediateResults.removeFirst();
                final int x=intermediateResults.removeFirst();
                switch (token.charAt(0)) {
                    case '+':
                        intermediateResults.addFirst(x+y);
                        break;
                    case '-':
                        intermediateResults.addFirst(x-y);
                        break;
                    case '*':
                        intermediateResults.addFirst(x*y);
                        break;
                    case '/':
                        intermediateResults.addFirst(x/y);
                        break;
                    default:
                        throw new IllegalArgumentException("Malformed RPN at :"+token);
                }
            } else { // token is a number.
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }
        return intermediateResults.removeFirst();
    }

    public static boolean isWellFormedABoolean(String s) {
        Deque<Character> leftChars=new LinkedList<>();
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') {
                leftChars.addFirst(s.charAt(i));
            } else {
                if (leftChars.isEmpty()) {
                    return false; // Unmatched right char.
                }
                if ((s.charAt(i)==')'&&leftChars.peekFirst()!='(')
                        ||(s.charAt(i)==')'&&leftChars.peekFirst()!='{')
                        ||(s.charAt(i)==']'&&leftChars.peekFirst()!='[')) {
                    return false; // Mismatched chars.
                }
                leftChars.removeFirst();
            }
        }
        return leftChars.isEmpty();
    }
}
