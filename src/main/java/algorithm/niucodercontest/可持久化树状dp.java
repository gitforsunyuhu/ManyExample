package algorithm.niucodercontest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class 可持久化树状dp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n <= 0) {
            return;
        }
        ArrayList<Long> a = new ArrayList<Long>();
        long cost = 0;
        for(int i =0; i< n; i++){
            Long m = sc.nextLong();
            if(m <=0 ){
                cost += m * (i+1);
            }else{
                cost += m;
            }

        }

        System.out.println(cost);
    }

}
