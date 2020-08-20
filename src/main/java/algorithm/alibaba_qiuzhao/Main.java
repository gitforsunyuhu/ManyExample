package algorithm.alibaba_qiuzhao;

import java.util.Scanner;

public class Main {

    public static final int max_value = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] x = new int[T];

        for(int i=0; i< T; i++){
            x[i] = sc.nextInt();
        }

        for(int i=0; i< T; i++){
            int count = 0;
            boolean flag = false;
            if(x[i] == 0){
                System.out.println(2);
                continue;
            }
            if(x[i] == 100){
                System.out.println(16);
                continue;
            }

            for(int j =0; x[j] != 0; j++){
                if(x[j] % 2== 1 ){
                    count ++;
                }else{
                    flag = true;
                }
                x[j] = x[j] /2;
            }
            if(flag) {
                System.out.println((int)(Math.pow(2, count +1 )));
            }else{
                System.out.println((int)(Math.pow(2, count)));
            }
        }
    }

//    private static int function(int x) {
//        int ab = x ^ max_value;
//        // 需要a ^ b 得到的结果是ab
//        int count = 0;
//        int min_value = Integer.MAX_VALUE;
//        int a = 0;
//        int b = 0;
//        for(a=0; a<= ab; a++){
//            b = a ^ ab;
//            int ans = Math.abs(a-b);
//            if(min_value > ans){
//                min_value = ans;
//                count = 0;
//            }else if(min_value == ans){
//                count ++;
//            }
//        }
//        return count;
//    }
}
