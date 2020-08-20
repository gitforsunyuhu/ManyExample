package algorithm.langchao;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[101];
        int[] b = new int[101];
        int count = 0;
        int maxlen = 0;
        for(int i=0; i< n; i++){
            int input = sc.nextInt();
            if(input % 2 == 0){
                b[input] = 1;
            }else{
                a[input] = 1;
            }
        }


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        getJishu(hashMap, a);
        getOushu(hashMap, b);

        Set<Integer> set = hashMap.keySet();
        for (Integer i : set){
            if(hashMap.get(i) > maxlen){
                maxlen = hashMap.get(i);
                count = i;
            }
        }
        System.out.println(count + " " + maxlen);
    }

    private static void getOushu(HashMap<Integer, Integer> hashMap, int[] a) {
        int maxlen =0;
        int count = 0;
        hashMap.put(2, 0);
        int index = 2;
        for(int i=2; i<= 100; ){
            if(a[i] == 1){
                hashMap.replace(index, count);
                while(i <= 99 && a[i] == 1){
                    i += 2;
                }
                if(i > 100){
                    break;
                }
                hashMap.put(i,0);
                index = i;
                count = 0;
                continue;
            }
            count ++;
            i += 2;
        }

        if(count != 0){
            hashMap.replace(index, count);
        }
        Set<Integer> set = hashMap.keySet();
//        System.out.println(" ============");
//        for(Integer key: set){
//            System.out.println(key + "  " + hashMap.get(key));
//        }
    }

    private static void getJishu(HashMap<Integer, Integer> hashMap, int[] a) {
        int maxlen =0;
        int count = 0;
        hashMap.put(1, 0);
        int index = 1;
        for(int i=1; i<= 99; ){
            if(a[i] == 1){
                hashMap.replace(index, count);
                while(i <= 99 && a[i] == 1){
                    i += 2;
                }
                if(i > 99){
                    break;
                }
                hashMap.put(i,0);
                index = i;
                count = 0;
                continue;
            }
            count ++;
            i += 2;
        }

        if(count != 0){
            hashMap.replace(index, count);
        }
//        Set<Integer> set = hashMap.keySet();
//        for(Integer key: set){
//            System.out.println(key + "  " + hashMap.get(key));
//        }
    }
}
