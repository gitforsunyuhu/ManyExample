package container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "1");
        // 如果是键相同的话，将会覆盖原来的内容
        hashMap.put(1, "2");
        // 五种遍历方法--1
        Set<Integer> keySet = hashMap.keySet();
        for(Integer integer : keySet) {
            System.out.println(integer + " : " +  hashMap.get(integer));
        }

        // 第二种
        for(Map.Entry entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + " : " +  entry.getValue());
        }

        // 第三种
        hashMap.forEach((k,v) -> System.out.println(k + " : " + v ));
    }
}
