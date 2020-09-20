package algorithm.pingduoduo;

import java.util.Scanner;

/**
 * 0 2 1 0
 * 3 0 0 8
 * 4 0 0 7
 * 0 5 6 0
 *
 *
 * 0 2 0 1 0
 * 3 0 0 0 8
 * 0 0 0 0 0
 * 4 0 0 0 7
 * 0 5 0 6 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ans4 = {
                {0, 2, 1, 0},
                {3, 0, 0, 8},
                {4, 0, 0, 7},
                {0, 5, 6, 0}
        };
        int[][] ans5 = {
                {0, 2, 0,1, 0},
                {3, 0, 0,0, 8},
                {0, 0, 0,0, 0},
                {4, 0, 0,0, 7},
                {0, 5, 0,6, 0}
        };
        if(n % 2 == 0){
            func1(n);
        }else{
            func2(n);
        }
    }

    // 偶数
    public static void func1(int n){
        for (int i = 0;  i < n/ 2; i++){
            // 输出 3
            for (int j = i-1; j >= 0 ; j --) {
                System.out.print(3 + " ");
            }
            System.out.print(0 + " ");
            // 输出 2
            for(int j = i + 1; j < n/2; j++){
                System.out.print(2 + " ");
            }
            // 输出 1
            for (int j = n/2 ; j < n - i -1; j ++) {
                System.out.print(1 + " ");
            }
            // 输出 8
            for(int j = n - i -1; j < n; j++){
                if( j == n - i -1){
                    if(j == n-1){
                        System.out.println(0);
                    }else{
                        System.out.print(0 + " ");
                    }
                }else{
                    if(j == n-1){
                        System.out.println(8);
                    }else{
                        System.out.print(8 + " ");
                    }
                }
            }
        }

        for (int i = n / 2;  i < n; i++){
            // 输出 4
            for (int j = 0; j < n- i -1 ; j ++) {
                System.out.print(4 + " ");
            }
            System.out.print(0 + " ");

            // 输出 5
            for(int j = 0; j < i -n/2; j++){
                System.out.print(5 + " ");
            }
            // 输出 6
            for (int j = 0 ; j < i- n/2; j ++) {
                System.out.print(6 + " ");
            }
            // 输出 7
            for(int j = 0; j < n- i; j++){
                if( j == 0){
                    if(j == n- i -1){
                        System.out.println(0);
                    }else{
                        System.out.print(0 + " ");
                    }
                }else{
                    if(j == n- i -1){
                        System.out.println(7);
                    }else{
                        System.out.print(7 + " ");
                    }
                }
            }
        }
    }
    // jishu
    public static void func2(int n){
        for (int i = 0;  i < (n-1)/ 2; i++){
            // 输出 3
            for (int j = i-1; j >= 0 ; j --) {
                System.out.print(3 + " ");
            }
            System.out.print(0 + " ");
            // 输出 2
            for(int j = i + 1; j < n/2; j++){
                System.out.print(2 + " ");
            }
            System.out.print(0 + " ");
            // 输出 1
            for (int j = (n+1)/2 ; j < n - i -1; j ++) {
                System.out.print(1 + " ");
            }
            // 输出 8
            for(int j = n - i -1; j < n; j++){
                if( j == n - i -1){
                    if(j == n-1){
                        System.out.println(0);
                    }else{
                        System.out.print(0 + " ");
                    }
                }else{
                    if(j == n-1){
                        System.out.println(8);
                    }else{
                        System.out.print(8 + " ");
                    }
                }
            }
        }
        for(int i= 0; i< n-1; i++){
            System.out.print("0" + " ");
        }
        System.out.println(0);

        for (int i = (n+1) / 2;  i < n; i++){
            // 输出 4
            for (int j = 0; j < n- i -1 ; j ++) {
                System.out.print(4 + " ");
            }
            System.out.print(0 + " ");

            // 输出 5
            for(int j = 0; j < i - (n+1)/2; j++){
                System.out.print(5 + " ");
            }
            System.out.print(0 + " ");
            // 输出 6
            for (int j = 0 ; j < i- (n+1)/2; j ++) {
                System.out.print(6 + " ");
            }
            // 输出 7
            for(int j = 0; j < n- i; j++){
                if( j == 0){
                    if(j == n- i -1){
                        System.out.println(0);
                    }else{
                        System.out.print(0 + " ");
                    }
                }else{
                    if(j == n- i -1){
                        System.out.println(7);
                    }else{
                        System.out.print(7 + " ");
                    }
                }
            }
        }
    }
}
