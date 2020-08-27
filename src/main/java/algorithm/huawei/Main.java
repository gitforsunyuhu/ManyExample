package algorithm.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        //System.out.println(Integer.MAX_VALUE);
        String[] nums = numbers.split(" ");

        if(nums.length == 1){
            String temp = Long.toBinaryString(Long.parseLong(nums[0]));
            while(temp.length() < 32){
                temp = "0" + temp;
            }
            String str = exchange(temp);
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(30));
            sb.append(str.charAt(31));
            sb.append(str.substring(0, 30));

            System.out.println(toNum(sb.toString()));

            return;
        }
        int n = nums.length;
        ArrayList<String> strings = new ArrayList<>();

        for(int i =0; i < n; i++){
            String temp = Long.toBinaryString(Long.parseLong(nums[i]));
            while(temp.length() < 32){
                temp = "0" + temp;
            }
            strings.add(exchange(temp));
        }

//        for(String str : strings){
//            System.out.println(str);
//        }

        for(int i = n; i <= 2*n -1; i++){
            String str1 = strings.get((i-1)%n);
            String str2 = strings.get(i%n);
            char c1 = str1.charAt(30);
            char c2 = str1.charAt(31);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(c1);
            sb1.append(c2);
            for(int k = 0; k < 30; k++){
                sb1.append(str2.charAt(i));
            }
            System.out.println(toNum(sb1.toString()));
        }
    }

    private static long toNum(String toString) {
        long ans = 0;
        long temp = 1;
        for(int i = 31; i >= 0; i--){
            if(toString.charAt(i) == '1'){
                ans += temp;
            }
            temp = temp * 2;
        }
        return ans;
    }

    public static String exchange(String string){
        StringBuilder sb = new StringBuilder();
        for(int i = 15; i >=0; i --){
            sb.append(string.charAt(i*2));
            sb.append(string.charAt(i*2+1));
        }
        sb.reverse();
        return sb.toString();
    }
}
