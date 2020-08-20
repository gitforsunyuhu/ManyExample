package algorithm.shein;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i= 0; i< n; i++){
            arr[i] = sc.nextInt();
        }

        int i = 0;
        int j = i + 1;
        for(; i < (n+1)/2 ; j++){
            if(j < n && arr[j-1] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        for(i=0; i< n; i++){
            System.out.print(arr[i]);
        }

    }
}
