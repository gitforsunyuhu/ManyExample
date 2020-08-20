package algorithm.langchao;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.replace(1,8);
        System.out.println(hashMap.get(1));
    }
}
