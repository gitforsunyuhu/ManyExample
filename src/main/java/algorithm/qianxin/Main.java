package algorithm.qianxin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();

        for(int i = 0; i< n.length(); i++){
            if(n.charAt(i) < '0' || n.charAt(i) > '9'){
                System.out.println(0);
            }
        }
        if(Integer.parseInt(n) <= 0 || Integer.parseInt(n) > 36){
            System.out.println(0);
            return;
        }
        System.out.println( getAns(Integer.parseInt(n)));
    }

    public static int getAns(int n){
        int[] dp = new int[n+5];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
