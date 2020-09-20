package algorithm.pingduoduo;

import java.util.Scanner;

public class Main2 {
    static int[][] f = new int[405][405];
    static int[][] mp = new int[405][405];
    static int[] sum = new int[16005];
    static int[] used = new int[16005];
    static int[] fx = {1,-1, 0,0};
    static int[] fy = {0,0, 1,-1};
    static int cnt = 0;
    static int n;
    static int m;
    public static void bfs(int i, int j){
        f[i][j] = cnt;
        sum[cnt] ++;
        for (int k = 0 ; k< 4; k++){
            int ni = i + fx[k];
            int nj = j + fy[k];
            if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
            if(mp[ni][nj] == 0 || f[ni][nj] >= 1) continue;
            bfs(ni, nj);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mp[i][j] = scanner.nextInt();
            }
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mp[i][j] == 0 || f[i][j] >= 1){
                    continue;
                }
                cnt ++;
                bfs(i, j);
                ans = Math.max(ans, sum[cnt]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mp[i][j] == 1){
                    continue;
                }
                int tot = 1;
                int gp = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + fx[k];
                    int nj = j + fy[k];
                    if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                    if(mp[ni][nj] == 0 ) continue;
                    int fa = f[ni][nj];
                    used[fa] = 0;
                }
                if(gp == cnt) tot --;
                ans = Math.max(ans, tot);
            }
        }
        System.out.println(ans);
    }
}
