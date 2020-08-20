package algorithm.kedaxuefei0731;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();
        //
        int tempx = Math.abs(x1 + x2- x3- x4);
        int tx = Math.abs(x1 - x2) + Math.abs(x3 - x4);
        int tempy = Math.abs(y1 + y2- y3- y4);
        int ty = Math.abs(y1 - y2) + Math.abs(y3 - y4);

        if( tempx <= tx && tempy <= ty){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
