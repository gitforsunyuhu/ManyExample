package algorithm.arrayandstring;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * 确定一个字符串的所有字符是否全都不同
 * 假设不允许使用额外的数据结构
 */
public class Book1and1 {

    public boolean checkDifferent(String iniString) {
        // 边界处理
        if(iniString == null || iniString.length() == 0 || iniString.length() > 256) {
            return false;
        }
        int[] map = new int[256];
        for(int i = 0; i< iniString.length(); i++){
            if(map[iniString.charAt(i)] == 1){
                return false;
            }
            map[iniString.charAt(i)] = 1;
        }
        HashMap 啊;
        ArrayList arrayList;
        return true;
    }


}
/**

 解法1
 public boolean checkDifferent(String iniString) {
 // 边界处理
 if(iniString == null || iniString.length() == 0) {
 return false;
 }
 //最基础的就是o(n*n)
 for(int i = 0; i< iniString.length()-1; i++){
 for(int j = i+1; j < iniString.length(); j++){
 if(iniString.charAt(i) == iniString.charAt(j)){
 return false;
 }
 }
 }
 return true;
 }

 复杂度为  n*n


 */