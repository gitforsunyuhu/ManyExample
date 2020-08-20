package algorithm.zhanhangxinyongka;

import java.util.Scanner;

public class AA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k > n){
            System.out.println(-1);
        }else{
            System.out.println(f(n,k));
        }
    }

    public static String f(int n, int k){
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i=0; i< n; i++){

            count ++;
        }
        return sb.toString();
    }
}
