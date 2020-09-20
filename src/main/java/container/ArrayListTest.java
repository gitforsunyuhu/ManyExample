package container;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add("a");
        }
        for (int i = 0; i < a.size(); i++) {
            a.remove(i);
            System.out.println(a);
        }
        HashMap b;
    }
}
