package algorithm.vipkids;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            getAns(n);
        }

    }

    public static void getAns(int n){

        int[][] map = new int[n][n];
        int row = 0;
        int col = 0;
        int number = 1;
        for(int i= 0; i < (n+1)/2 ; i++){
            row = i;
            col = i;
            for(int j = i; j < n-i; j ++){
                map[row][col ++] = number ++;
            }
            col --;
            for(int j = i; j < n-i -1; j ++){
                map[ ++ row][col] = number ++;
            }

            for(int j = i; j < n-i-1; j ++){
                map[row][ --col] = number ++;
            }

            for(int j = i; j < n-i-2; j++){
                map[-- row][col] = number ++;
            }
        }

        int[][] newmap = new int[2*n][2*n];
        for(int i = 0; i< n; i++){
            for (int j = 0; j < n; j++) {
                newmap[i][j] = map[i][j];
            }
            int jj = n-1;
            for (int j = n; j <2* n; j++){
                newmap[i][j] = map[i][jj --];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2*n ; j++){
                newmap[i+n][j] = newmap[n-i-1][j];
            }
        }

        for (int i = 0; i < 2 * n; i++) {
            System.out.print(newmap[i][0]);
            for (int j = 1; j < 2 * n; j++) {
                System.out.print( " " + newmap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
