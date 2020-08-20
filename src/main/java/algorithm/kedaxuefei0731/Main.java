package algorithm.kedaxuefei0731;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] number = new int[n];
        for(int i=0; i < n; i++){
            number[i] = sc.nextInt();
        }
        int temp = 0;
        int increase = n;

        while(true){
            increase /= 2;
            for(int i = 0; i< increase; i++){
                for(int j = i+ increase; j < n; j += increase){
                    for(int k = j; k > i; k -= increase){
                        if(number[k - increase ] > number[k]){
                            temp = number[k - increase ];
                            number[k- increase] = number[k];
                            number[k] = increase;
                        }else{
                            break;
                        }
                    }
                }
            }
            for(int i=0; i< n-1; i++){
                System.out.print(number[i] + " ");
            }
            System.out.println(number[n-1]);
            if(increase == 1){
                break;
            }
        }
//        for(int i=0; i< n-1; i++){
//            System.out.print(number[i] + " ");
//        }
//        System.out.println(number[n-1]);

        //第一题
//        Scanner sc = new Scanner(System.in);
//        int [] money = {1,5, 10, 50, 100};
//        int [] number = new int[5];
//        int total = 0;
//        for(int i=0; i< 5; i++){
//            number[i] = sc.nextInt();
//            total += number[i] * money[i];
//        }
//        int price = sc.nextInt();
//        if(total < price){
//            System.out.println(-1);
//            return;
//        }
//        int count = 0;
//
//        if(price >= 100){
//            int temp = price / 100;
//            if(temp > number[4]){
//                temp = number[4];
//            }
//            count += temp;
//            price = price - temp * 100;
//        }
//        if(price >= 50){
//            int temp = price / 50;
//            if(temp > number[3]){
//                temp = number[3];
//            }
//            count += temp;
//            price = price - temp * 50;
//        }
//        if(price >= 10){
//            int temp = price / 10;
//            if(temp > number[2]){
//                temp = number[2];
//            }
//            count += temp;
//            price = price - temp * 10;
//        }
//        if(price >= 5){
//            int temp = price / 5;
//            if(temp > number[1]){
//                temp = number[1];
//            }
//            count += temp;
//            price = price - temp * 5;
//        }
//        if(price > number[0]){
//            System.out.println(-1);
//        }else{
//            System.out.println(count + price);
//        }
    }
}
