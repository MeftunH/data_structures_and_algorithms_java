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

    public static String shortestEquivalentPath(String path) {
        if (path.isEmpty()) {
            throw new IllegalArgumentException("Empty string is not a valid path.");
        }
        Deque<String> pathNames=new LinkedList<>();
        // Special case: starts with "/", which is an absolute path.
        if (path.startsWith("/")) {
            pathNames.addFirst("/");
        }
        for (String token : path.split("/")) {
            if (token.isEmpty()||token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (pathNames.isEmpty()||pathNames.peekFirst().equals("..")) {
                    pathNames.addFirst(token);
                } else {
                    if (pathNames.peekFirst().equals("/")) {
                        throw new IllegalArgumentException("Path error, trying to go above root.");
                    }
                    pathNames.removeFirst();
                }
            } else { // Must be a name.
                pathNames.addFirst(token);
            }
        }
        StringBuilder result=new StringBuilder();
        if (!pathNames.isEmpty()) {
            final String dir=pathNames.removeFirst();
            result.append(dir);
        }
        while (!pathNames.isEmpty()) {
            result.append("/").append(pathNames.removeFirst());
        }
        return result.toString();
    }
}
