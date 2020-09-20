package algorithm.gaotuketang;

import java.util.*;
import java.util.Scanner;

public class Main_1 {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list =new  ArrayList<Integer>();
        int count = 0;
        while(sc.hasNext()) {
            list.add(sc.nextInt());
            count ++;
        }
        int n =list.get(count-1);
        int left = 0;
        int right = count -2;
        while (left < right){
            int mid = left + (right - left)/ 2;
            if(list.get(mid) == n){
                System.out.println(mid);
                return;
            }
            if(list.get(mid) < n){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        if(list.get(left) == n){
            System.out.println(left);
            return;
        }else if(list.get(left) < n){
            System.out.println(left + 1);
        }else{
            System.out.println(left -1);
        }
    }

    public static int getAns(int n, int m){
        ans = (int)(Math.log(m)/Math.log(2));
        return ans;
    }
}
