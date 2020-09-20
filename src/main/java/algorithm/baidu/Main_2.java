package algorithm.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Node{
    public int x;
    public int y;
}

public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int k = 0;
        int n = 0;
        int m = 0;
        int p[] = new int[1005];

        for (int i = 0; i < T; i++) {
            Arrays.fill(p, 0);
            n = in.nextInt();
            m = in.nextInt();
            for (int j = 1; j <= m; j++) {
                k = in.nextInt();
                for (int l = 1; l <= k; l++) {
                    int x, y;
                    x = in.nextInt();
                    y = in.nextInt();
                    for (int t = x; t <= y; t++) {
                        p[t]++;
                    }
                }
            }
            int num = 0;
            for (int ii = 1; ii <= n; ii++) {
                if (p[ii] == m)
                    num++;
            }
            System.out.println(num);
            for (int ii = 1; ii <= n; ii++) {
                if (p[ii] == m)
                    System.out.print(ii + " ");
            }
            System.out.println();
        }
    }
}