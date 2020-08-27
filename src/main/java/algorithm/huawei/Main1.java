package algorithm.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> width = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int i = 0;
        String temp = "";
        if(false){
            System.out.println(0);
        }else{
            for( ; i < s.length(); i++){
                if(s.charAt(i) == '[')
                    continue;
                else if(s.charAt(i) == ']')
                    break;
                else if (s.charAt(i) == ','){
                    height.add(Integer.parseInt(temp));
                    temp = "";
                }else
                    temp += s.charAt(i);
            }
            height.add(Integer.parseInt(temp));
            temp = "";
            i += 2;
            for( ; i < s.length(); i++){
                if(s.charAt(i) == '[')
                    continue;
                else if(s.charAt(i) == ']')
                    break;
                else if (s.charAt(i) == ','){
                    width.add(Integer.parseInt(temp));
                    temp = "";
                }else
                    temp += s.charAt(i);
            }
            width.add(Integer.parseInt(temp));
            temp = "";
            for(int k = 0; k < width.size(); k ++){
                System.out.print(width.get(k) + " ");
            }
            System.out.println();
            if(feifa(height, width) == false){
                System.out.println(0);
            }else{
                System.out.println(helper(height, width));
            }
        }
    }

    private static boolean feifa(ArrayList<Integer> height, ArrayList<Integer> width) {
        if(width.size() != height.size()){
            return false;
        }
        if(width.size() <= 0 || width.size() > 100){
            return false;
        }
        for (int i = 0; i< width.size(); i++){
            if(width.get(i) <= 0 || width.get(i) > 100)
                return false;
            if(height.get(i) <= 0 || height.get(i) > 100){
                return false;
            }
        }
        return true;
    }

    private static int helper(ArrayList<Integer> height, ArrayList<Integer> width) {
        int n = height.size();
        int ans = 0;
        for (int i = 0; i< n; i++){
            for (int j = 0; j< n; j++){
                int mi = 101;
                int sm = 0;
                for (int k = i; k <=j ; k++){
                    mi = Math.min(mi, height.get(k));
                    sm += width.get(k);
                }
                ans  = Math.max(ans, mi *sm);
            }
        }
        return ans;
    }
}
