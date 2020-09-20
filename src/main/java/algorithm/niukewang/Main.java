package algorithm.niukewang;

public class Main {

    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        int dp[] = new int[cap +1];
        for (int i = 0; i < n; i++) {
            for (int j = cap; j - w[i] >=0 ; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[cap];
    }
}
