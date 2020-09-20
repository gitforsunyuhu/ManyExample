package algorithm.vipkids;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 编写一个算法把中文的字符串转换成整数，
 * 不用考虑long的溢出问题，假设它可以存储任意大的整数。
 * long parseChineseNumber(string s);
 * 测试用例： 1. "一千零一" -> 1001
 * 2. "一千零一万五千四百三十二亿九千八百七十六万四千三百零二" -> 1001543298764302
 * 3. "十五" -> 15
 * 4. "五万三" -> 53000
 * 5. "四万亿" -> 4000000000000
 */
public class Main_2 {

    // 记录当前指针之前的最大数字单位
    public static Stack<Long> stack = new Stack<Long>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        getAns(number);
    }

    public static void getAns(String number){
        int len = number.length();
        long ans = 0;
        int yitime = 0;
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            if(isNumberChar(c)){
                if(getNumberChar(c) == 0){
                    continue;
                }
                if(i == len -1){
                    ans += getNumberChar(c);
                }else{
                    long unit = getUnit(number.charAt(i+1));
                    if(unit == 100000000){
                        yitime ++;
                    }
                    if(stack.isEmpty()){
                        stack.push(unit);
                        ans += getNumberChar(c) * unit;
                        i++;
                    }else if(stack.peek() < unit){
                        stack.pop();
                        stack.push(unit);
                        ans = (ans + getNumberChar(c)) * unit;
                        i++;
                        if(yitime == 1){
                            stack.pop();
                            yitime = 0;
                        }
                    }else{
                        ans += getNumberChar(c) * unit;
                        i++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static long getUnit(char c){
        if(c == '十'){
            return 10;
        }
        if(c == '百'){
            return 100;
        }
        if(c == '千'){
            return 1000;
        }
        if(c == '万'){
            return 10000;
        }else{
            return 100000000;
        }
    }

    public static long getNumberChar(char c){
        if(c == '零'){
            return 0;
        }
        if(c == '一'){
            return 1;
        }
        if(c == '二'){
            return 2;
        }
        if(c == '三'){
            return 3;
        }
        if(c == '四'){
            return 4;
        }
        if(c == '五'){
            return 5;
        }
        if(c == '六'){
            return 6;
        }
        if(c == '七'){
            return 7;
        }
        if(c == '八'){
            return 8;
        }else{
            return 9;
        }
    }

    public static boolean isNumberChar(char c){
        if(c == '零' || c == '一'|| c == '二'|| c == '三' || c == '四'|| c == '五'|| c == '六'||
                c == '七'|| c == '八' || c== '九'){
            return true;
        }
        return false;
    }
}
