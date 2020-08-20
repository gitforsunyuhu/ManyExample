package algorithm.digui.leetcode;

import java.util.Stack;

public class Num32 {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int templen = 0;
        int maxlen = 0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                if(!stack.isEmpty()){
                    if(maxlen < templen){
                        maxlen = templen;
                    }
                    while(!stack.isEmpty())
                        stack.pop();
                    templen = 0;
                }
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    templen = templen + 2;
                    if(maxlen < templen){
                        maxlen = templen;
                    }
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(new Num32().longestValidParentheses("()(()"));
    }
}
