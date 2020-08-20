package multithread.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 此类用于测试Executors的线程工厂和拒绝策略
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatOfGroup){
        namePrefix = "UserThreadFactory's " + whatOfGroup + "-Woker-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0);
        System.out.println(thread.getName());
        return thread;
    }

    public static void main(String[] args) {
        UserThreadFactory userThreadFactory = new UserThreadFactory("中国，南京，南京大学");
        Task task = new Task();
        for (int i = 0; i < 10; i++) {
            userThreadFactory.newThread(task).start();
        }
    }
}
class Task implements Runnable{
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run(){
        System.out.println("running" + count.getAndIncrement());
    }
}

