package algorithm.digui;

import java.util.ArrayList;
import java.util.Collections;

public class JZ27{
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        //输入异常处理
        if(str == null || str.length() == 0){
            return list;
        }
        char[] chars = str.toCharArray();
        getPermutation(list, chars, 0, str);
        Collections.sort(list);
        return  list;
    }
    public void getPermutation(ArrayList<String> list, char[] chars, int index, String str){
        if(index == str.length()-1){
            if(!list.contains(new String(chars)))
                list.add(new String(chars));
        }

        for(int j = index; j < str.length() ; j++) {
            swap(chars, index, j);
            getPermutation(list, chars, index + 1, str);
            swap(chars, index, j);
        }
    }

    public void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        JZ27 jz27 = new JZ27();
        for (String str: jz27.Permutation("aac")) {
            System.out.println(str.toString());
        }
    }
}