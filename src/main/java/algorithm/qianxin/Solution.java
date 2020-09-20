package algorithm.qianxin;

import java.util.*;
import java.util.stream.Stream;


public class Solution {
    /**
     *
     * @param person int整型一维数组
     * @return int整型
     */
    public int house (int[] person) {
        // write code here
        if(person == null || person.length == 0){
            return 0;
        }
        int sum = 1;
        int len = person.length;
        int pre = 1;
        for(int i = 1; i < len; i++){
            if(person[i] > person[i-1]){
                sum = sum + pre + 1;
                pre = pre +1;
            }else{
                if(pre == 1){
                    int index = i-1;
                    while(index >=0){
                        if(person[index] - person[index +1] < 0){
                            break;
                        }
                        sum  ++;
                        index --;
                    }
                    pre = 1;
                }else{
                    sum = sum + 1;
                    pre = 1;
                }
            }
        }
        return sum;
    }
}