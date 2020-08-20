package multithread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本实例演示了如果不显示的调用threadLocal的remove()方法
 * 有可能会产生脏数据的情况。
 */
public class DirtyDataInThreadLocal {
    public static  ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            MyThread myThread = new MyThread();
            executorService.execute(myThread);
        }
    }

    private static class MyThread extends Thread {
        public static boolean flag = true;
        @Override
        public void run() {
            if(flag){
                threadLocal.set("这个是" +this.getName()+ ", 会话信息");
                flag = false;
            }
            System.out.println(this.getName() + " 线程是：" + threadLocal.get());
            //如果第一个线程没有进行remove函数的调用，后面得到的结果依然是第一次的结果
            //Thread-0 线程是：这个是Thread-0, 会话信息
            //Thread-1 线程是：这个是Thread-0, 会话信息
            //如果调用了下面的方法，后面是得不到结果的，因为没有设置初始值。
            //Thread-0 线程是：这个是Thread-0, 会话信息
            //Thread-1 线程是：null
            //threadLocal.remove();
        }
    }
}
