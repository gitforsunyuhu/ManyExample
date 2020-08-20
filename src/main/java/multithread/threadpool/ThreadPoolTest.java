package multithread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;


/**
 * 此类用于测试Executors的线程工厂和拒绝策略
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                 new SynchronousQueue<Runnable>());
        Thread newWorkStealingPool = (Thread) Executors.newWorkStealingPool();
        Thread newCachedThreadPool = (Thread) Executors.newCachedThreadPool();
        Thread newFixedThreadPool = (Thread) Executors.newFixedThreadPool(2);
        Thread newSigleThreadExecutor = (Thread) Executors.newSingleThreadExecutor();
        Thread newScheduledThreadPool = (Thread) Executors.newScheduledThreadPool(2);
    }
}
