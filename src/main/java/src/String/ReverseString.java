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
        byConcat();
    }

    public static void byConcat(){
        String str="ABCD";
        String rev="";
        int len=str.length();
        str.charAt(0);
        for (int i=len-1; i>=0; i--) {
            rev=rev+str.charAt(i);
        }
        System.out.println(rev);
    }

}
