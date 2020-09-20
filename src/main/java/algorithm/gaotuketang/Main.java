package algorithm.gaotuketang;

import java.util.Scanner;

public class Main {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int rest  = m;
        int max = Integer.MIN_VALUE;
        int curreat = m;
        int mm = m;
        while(mm > 0){
            boolean flag = true;
            int first = curreat;
            for(int i = 0 ; i < n; i++){
                if(curreat % 2 == 0){
                    rest = rest - curreat;
                    if(rest <= 0){
                        flag = false;
                        break;
                    }
                    curreat = curreat /2;
                }else {
                    rest = rest - curreat;
                    if(rest <= 0){
                        flag = false;
                        break;
                    }
                    curreat = curreat /2 +1;
                }
            }
            if(flag && max < first){
                max = first;
                break;
            }
            mm --;
            curreat = mm;
        }
        System.out.println(max);
    }
}
