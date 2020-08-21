package algorithm.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        int c[] = new int[m];
        for(int i=0 ; i < n; i++){
            a[i] = sc.nextInt();
        }

        for(int j = 0; j< m; j++){
            b[j] = sc.nextInt();
            c[j] = sc.nextInt();
        }

        int maxvalue = -Integer.MAX_VALUE;
        int ans = 0;
        boolean flag[] = new boolean[n];
        sortTwoArr(b,c);
        Arrays.sort(a);
        for( int j=0; j < m; j++){
            for( int i =0; i< n; i++){
                if(b[j] <= a[i]  && !flag[i]){
                    maxvalue = c[j];
                    flag[i] = true;
                    break;
                }
            }
            ans += maxvalue;
            maxvalue = -Integer.MAX_VALUE;
        }
        System.out.println(ans);
    }

    public static void sortTwoArr(int[] b, int[] c){
        for(int i=0; i< b.length -1; i++){
            for(int j = i+1; j< b.length; j++){
                if(c[j] > c[i]){
                    int temp = c[j];
                    int temp1 = b[j];
                    b[j] = b[i];
                    c[j] = c[i];
                    b[i] = temp1;
                    c[i] = temp;
                }
            }
        }
    }
}
