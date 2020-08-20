package algorithm.niucodercontest;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0){
            return;
        }
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        int[] b = new int[n];
        int index = 0;
        int flag = 0;
        for(int i =0; i < n-1 ; i++){
            for(int j = i+1; j< n; j++){
                if(a[j] > a[i]){
                    b[i] = j+1;
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                b[i] = 0;
            }
            flag = 0;
        }
        b[n-1] = 0;
        for(int i=0; i< n-1; i++){
            System.out.print(b[i] + " ");
        }
        System.out.print(b[n-1]);
    }
}