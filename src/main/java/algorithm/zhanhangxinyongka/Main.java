package algorithm.zhanhangxinyongka;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int ans = 0;
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = sc.nextInt();
        queue.add(s);
        bfs(s, m);
        if(ans >= m){
            if(count == 1){
                System.out.println(count);
            }else{
                System.out.println(count-1);
            }
        }else{
            System.out.println(-1);
        }
    }

    public static void bfs(int s, int m){
        while(!queue.isEmpty()){
            int len = queue.size();
            int temp[] = new int[len];
            for(int i=0; i< queue.size(); i++) {
                temp[i] = queue.poll();
            }
            Arrays.sort(temp);
            for(int i = temp.length-1; i>=0 ; i--){
                if(temp[i] > 1){
                    if(temp[i] % 2 == 0){
                        ans += (temp[i]/2)*(temp[i]/2);
                        count ++;
                        if(ans >= m){
                            return;
                        }
                        queue.offer(temp[i]/2);
                        queue.offer(temp[i]/2);
                    }else {
                        ans += (temp[i]/2)*(temp[i] -temp[i]/2);
                        count ++;
                        if(ans >= m){
                            return;
                        }
                        queue.offer(temp[i]/2 + 1);
                        queue.offer(temp[i]/2);
                    }
                }
            }
        }
    }
}
