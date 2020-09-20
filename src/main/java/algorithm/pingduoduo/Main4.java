package algorithm.pingduoduo;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = scanner.nextInt();
        int[] m = new int[len];

        for (int i = 0; i < len; i++) {
            m[i] = scanner.nextInt();
        }
        System.out.println(getAns(n,m));
    }

    public static int getAns(int n, int[] m){
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            int num = m[i];
            res += n/ num;
        }
        for (int i = 0; i < m.length; i++){
            for (int j = i +1; j < m.length; j++){
                int num = m[i] * m[j];
                res -= n / num;
            }
        }
        return res;
    }
}
