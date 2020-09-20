package algorithm.shein;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(function(str1, str2));
    }

    public static int function(String str1, String str2){
        if(str1.length() < str2.length()){
            return 0;
        }
        int len2 = str2.length();
        int len1 = str1.length();
        int ans = Integer.MAX_VALUE;
        int dp[] = new int[256];
        int dp2[] = new int[256];
        int l = 0;
        for (int i = 0; i < len2; i++) {
            dp2[str2.charAt(i)] ++;
        }
        for (int i = 0; i < len1; i++) {
            dp[str1.charAt(i)]++;
            boolean flag = true;
            for (int k = 0; k < 256; k++) {
                if (dp[k] < dp2[k]) {
                    flag = false;
                }
            }
            if (flag) {
                while (true) {
                    dp[str1.charAt(l)]--;
                    if ((dp[str1.charAt(l)] < dp2[str1.charAt(l)])) {
                        dp[str1.charAt(l)]++;
                        break;
                    }
                    l++;
                }
                int cal = i - l + 1;
                ans = Math.min(ans, cal);
            }
        }
        if(ans > (int)Math.pow(10,6)) return 0;
        return ans;
    }
}

