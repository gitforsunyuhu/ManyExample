package algorithm.langchao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] maxlen = new int[n];
        for(int i=0; i< n; i++){
            for(int j = i; j < n; j++){
                if(a[j] -a[i] == 1){
                    maxlen[j] = Math.max(maxlen[i] + 1, maxlen[j]);
                }
            }
        }
        System.out.println(n - maxlen[n-1] + 1);
    }
}
