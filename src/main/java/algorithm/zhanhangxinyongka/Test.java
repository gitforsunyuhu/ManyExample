package algorithm.zhanhangxinyongka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i< n; i++){
            a[i] = sc.nextInt();
            System.out.println(f(a[i]));
        }
    }
    public static String f(int a){
        int baiwei = 0;
        int shiwei = 0;
        int gewei = 0;
        if(a / 100 !=0 ){
            baiwei = a/ 100;
            a = a% 100;
        }
        if(a / 10 != 0){
            shiwei = a/ 10;
            a = a% 10;
        }
        gewei = a;
        String baistr = baiwei != 0 ? Integer.toBinaryString(baiwei) : "";
        String shistr = shiwei != 0 ? Integer.toBinaryString(shiwei) : "";
        String gestr = Integer.toBinaryString(gewei);
        for(int i = baistr.length(); i < 4; i++){
            baistr = "0" + baistr;
        }
        for(int i = shistr.length(); i < 4; i++){
            shistr = "0" + shistr;
        }
        for(int i = gestr.length(); i < 4; i++){
            gestr = "0" + gestr;
        }

        String str = baistr + shistr + gestr;
        StringBuilder sb =new StringBuilder(str);
        String ss = sb.reverse().toString();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for(; i<ss.length(); i++){
            if(ss.charAt(i) != '0'){
                break;
            }
        }
        for(; i < ss.length(); i++){
            ans.append(ss.charAt(i));
        }
        return ans.toString();
    }
}
