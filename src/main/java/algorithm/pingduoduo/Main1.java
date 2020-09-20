package algorithm.pingduoduo;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] c = new int[n + 1];
        int[] v = new int[n + 1];

        int[] dp[] = new int[205][40005];
        for(int i = 1; i<= n; i++){
            c[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        for(int i =1; i <= n; i++ ){
            for(int j = 0; j<= 40000; j++){
                if(j - c[i] < 0 || j - c[i] >= 40000) continue;
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - c[i]] + v[i]);
            }
        }
        int ans = -1;
        for(int i = 20000; i <=  20000 + m; i++){
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
