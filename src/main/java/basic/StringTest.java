package basic;

import java.util.Arrays;
import java.util.Stack;

public class StringTest {

    public static void main(String[] args) {
        String s = "adsfas d";
        s.replace(" ", "%20");

        System.out.println(isFlipedString("saaa","asss"));


        String str = "aasdfasdfasdgfe";
        str.concat("ss");
        str.indexOf("asdf");

        StringBuffer sb = new StringBuffer();
        StringBuffer  sb1 = sb.reverse();
        Stack<Integer> stack = new Stack();
        Integer[] a = (Integer[])stack.toArray();
    }

    public static boolean isFlipedString(String s1, String s2) {
        if(s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0 ){
            return true;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        int len = 0;
        while(len < s1.length()){
            StringBuffer sb = new StringBuffer();
            sb.append(s1.substring(len,s1.length()));
            sb.append(s1.substring(0,len));
            if(sb.toString().equals(s2)){
                return true;
            }
            len ++;
        }
        return false;
    }
}
