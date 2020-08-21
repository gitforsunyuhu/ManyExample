package algorithm.shunfeng;

import java.util.Scanner;

/**
 * 克里森是一名赏金猎人，他平时需要完成一些任务赚钱。最近他收到了一批任务，
 * 但是受到时间的限制，他只能完成其中一部分。具体来说就是有n个任务，
 * 每个任务用l, r, w来表示任务开始的时间l，结束的时间r和完成任务获得的金钱。
 * 克里森是个贪心的人，他想知道自己在任务不冲突的情况下最多获得多少金钱。
 *
 * 输入描述
 * 第一行一个数n表示任务的个数。(1≤n≤1e3)
 *
 * 接下来n行每行三个整数l, r, w表示第i个任务的开始时间，结束时间，以及收益。(1≤l≤r≤1e6,1≤w≤1e9)
 *
 * 输出描述
 * 输出一个值表示克里森最多获得的金钱数量。
 */
public class Main1 {
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        long c[] = new long[n];
        long ans = 0;
        for(int i=0 ; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextLong();
            if( i % 2 == 0){
                ans += c[i];
            }
        }
        System.out.println(ans);

    }
}
