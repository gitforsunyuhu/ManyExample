package multithread.juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 测试CopyOnWriteArrayList
 */
public class JUCTest1 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->strings.add(Thread.currentThread().getName() + ": i")).start();
        }
        Thread.sleep(3000);
        System.out.println(strings.size());
    }
}
