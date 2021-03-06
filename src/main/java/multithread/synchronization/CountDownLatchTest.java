package multithread.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 此类用于CountDownLatch的示例
 * 这个主要用在需要计数的的地方，当特定任务完成之后才执行其他的任务；
 * 比如：关门线程需要在教室中的其他人都走了之后才开始执行
 * 其关键的方法是  countDown() 和 await()方法
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch  = new CountDownLatch(3);

        Thread thread1 = new TranslateThread("1st content", countDownLatch);
        Thread thread2 = new TranslateThread("2nd content", countDownLatch);
        Thread thread3 = new TranslateThread("3rd content", countDownLatch);

        thread1.start();
        thread2.start();
        thread3.start();

        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("所有线程已经完成");
    }

    private static class TranslateThread extends Thread {

        private  String s;
        private final CountDownLatch countDownLatch;
        public TranslateThread(String s, CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            this.s = s;
        }

        public void run(){
            System.out.println("-------开始：" + this.getName());
            //某种情况下，抛出异常
//            if( Math.random() > 0.5){
//                throw new RuntimeException("原文存在非法字符");
//            }

            System.out.println(s + "的翻译已经完成， 译文是。。。");
            countDownLatch.countDown();
        }
    }
}
