
package basic;    // package 必须放在第一行
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public abstract class Test {
    static int n  = 0;
    int a = 'a';
    short b =100;
    byte aa = 1;
    long ll;

    public Test() {
        ll = 88888888;
    }
    Thread thread =new Thread();

    public void Test(){

    }
    abstract void abstractfunc();
    int $aa  = a;
    public static void main(String[] args) {
//        Test t  = new Test();
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i< 100; i++){
            hashMap.put(i, i);
        }
        hashMap.put(1, 1);
        hashMap.put(10,2);
        hashMap.put(3, 1);
        hashMap.put(10,2);
        hashMap.put(4, 1);
        hashMap.put(90,2);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(null);
        list.add(1);
        for (Integer i:list) {
            System.out.println(i);
            // list.remove(i);
        }
        System.out.println(list);
        list.set(1, 1);
        String hash1 = "0";
        for(Integer i = 11; ; i++){
            if(i.hashCode() == hash1.hashCode()){
                System.out.println(i);
                break;
            }
        }
    }
}
class Base{
    protected void f(){}
}

class Sub extends Base{
    protected void f(){};
}