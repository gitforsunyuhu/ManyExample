package algorithm.yuanfudao;

public class Huixingjuzheng {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        f(a);

    }

    public static void f(int[][] a){
        if(a == null || a.length == 0 || a[0].length == 0) {
            return;
        }
        int n = a.length;
        int m = a[0].length;
        for(int i = 0; i < (n+1) / 2; i++) {
            int row = i;
            int col = i;

            while(col < m - i){
                System.out.println(a[row][col]);
                col ++;
            }
            row ++;
            while(row < n - i) {
                System.out.println(a[row][col]);
                row ++;
            }

            col --;
            if(col < 0) {
                continue;
            }else{
                while(col > i){
                    System.out.println(a[row][col]);
                    col --;
                }
            }
            row --;
            if(row < 0) {
                continue;
            }else{
                while(row > i){
                    System.out.println(a[row][col]);
                    row --;
                }
            }
        }
    }
}
