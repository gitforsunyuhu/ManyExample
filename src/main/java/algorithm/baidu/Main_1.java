package algorithm.baidu;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int count_0 = 0;
        int count_5 = 0;
        for(int i = 0; i< n; i++){
            a[i] = in.nextInt();
            if(a[i] == 0){
                count_0 ++;
            }
            if(a[i] == 5){
                count_5 ++;
            }
        }
        if(count_0 == 0 || count_5 < 2){
            System.out.println(-1);
            return;
        }

        count_5 = count_5 / 9;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count_5 ; i++){
            sb.append("5");
        }
        for(int i = 0; i< count_0; i++){
            sb.append("0");
        }
        System.out.println(sb.toString());
    }
}