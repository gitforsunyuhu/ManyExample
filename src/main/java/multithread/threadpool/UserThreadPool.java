package multithread.threadpool;

import java.util.concurrent.*;

public class UserThreadPool {
    public static void main(String[] args) {
        BlockingDeque blockingDeque = new LinkedBlockingDeque(2);
        UserThreadFactory f1 =new UserThreadFactory("第一机房");
        UserThreadFactory f2 =new UserThreadFactory("第二机房");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1,
                2, 60, TimeUnit.SECONDS,blockingDeque,
                f1, handler);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1,
                2, 60, TimeUnit.SECONDS,blockingDeque,
                f2, handler);
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolExecutor1.execute(task);
            threadPoolExecutor2.execute(task);
        }
    }
}
