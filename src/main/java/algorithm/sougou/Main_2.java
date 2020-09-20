package algorithm.sougou;

import java.util.Arrays;

public class Main_2 {

    public int numberofprize (int a, int b, int c) {
        // write code here
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        int k = arr[0];
        int m = arr[1] - arr[0];
        int n = arr[2] - arr[1];
        int ans = 0;
        if(n <= 1){
            ans = k + m/2;
        }else{
            int A = m + n;
            int B = m;
            if(A <= B){
                int t = n/2;
                int AA = m +n -t;
                int BB = m-t;
                ans = k + t + BB/2;
            }else{
                int t = B;
                A = A- 2*t;
                B = 0;
                ans = k + t + A/5;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        f(1,3);
    }

    public static void f(int a, int b){
        int[] aa = {a,b};
        for (int ss :
                aa) {
            System.out.println(ss);
        }
    }
}
