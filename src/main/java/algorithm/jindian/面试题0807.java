package algorithm.jindian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 面试题0807 {
    // 路径
    private static String[] ans = new String[72 * 42 * 120];
    private static int index = 0;

    public String[] permutation(String S) {
        if(S == null || S.length() == 0){
            return ans;
        }
        // 定义路径
        List list = new ArrayList();
        list.toArray(new String[0]);
        StringBuffer sb = new StringBuffer();
        backtrack(ans, sb, S);
        return Arrays.copyOfRange(ans, 0, index);
    }

    public static void backtrack(String[] ans, StringBuffer sb, String s){
        // 如果选择满足条件
        if(sb.length() == s.length()){
            ans[index ++] = sb.toString();
            return;
        }
        Integer a = new Integer(1);

        for(int i = 0; i < s.length(); i++){
            // 做选择
            if(sb.length() != 0 && containsStr(sb.toString(), s.charAt(i)))
                continue;
            sb.append(s.charAt(i));
            backtrack(ans, sb, s);
            // 撤销选择
            sb.deleteCharAt(sb.length() -1);
        }
    }


    public static boolean containsStr(String str, char s){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == s){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str = new 面试题0807().permutation("sach");
        for (int i = 0; i < index; i++) {
            System.out.println(str[i]);
        }
    }
}