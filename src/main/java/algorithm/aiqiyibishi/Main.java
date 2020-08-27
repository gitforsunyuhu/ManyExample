package algorithm.aiqiyibishi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        HashSet<String> map = new HashSet<>();
        int x = 0;
        int y = 0;
        // 需要初始化
        map.add(x + ":" + y);
        for(int i = 0; i< path.length(); i++){
            if(path.charAt(i) == 'N'){
                y ++;
                if(map.contains(x + ":" + y)){
                    System.out.println("True");
                    return;
                }
                map.add(x + ":" + y);
            }else if(path.charAt(i) == 'S'){
                y --;
                if(map.contains(x + ":" + y)){
                    System.out.println("True");
                    return;
                }
                map.add(x + ":" + y);
            }else if(path.charAt(i) == 'E'){
                x ++;
                if(map.contains(x + ":" + y)){
                    System.out.println("True");
                    return;
                }
                map.add(x + ":" + y);
            }else{
                x --;
                if(map.contains(x + ":" + y)){
                    System.out.println("True");
                    return;
                }
                map.add(x + ":" + y);
            }
        }
        System.out.println("False");
    }
}
