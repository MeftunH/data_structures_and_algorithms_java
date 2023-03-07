package src.String;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class ReverseString {
    public static void main(String[] args) {
        String str="Maftun";
        String rstr="";
        char ch;
        for (int i=0; i<str.length(); i++) {
            ch = str.charAt(i);
             rstr=ch+rstr;
        }
        System.out.println(rstr);
    }

}
