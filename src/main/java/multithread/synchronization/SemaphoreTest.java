package multithread.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * Semaphore示例
 * 此类和操作系统中的信号量相似，可以控制对互斥资源的访问数量
 * 比如在 过安检的时候 每次最多只能过10个人，这个时候可以先通过新建一个Semaphore变量，对其中的permits进行构造方法的传参
 * 在过安检之前通过调用acquire()方法看是否超过了最大的阈值，如果没有超过那么可以继续执行下面的代码
 * 如果超过了就需要等待。
 *
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore  = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }

    }

    private static class SecurityCheckThread extends Thread{
        private int i ;
        private final Semaphore semaphore;

        public SecurityCheckThread(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore =semaphore;
        }

        public void run(){
            try {
                // 获取到该信号量
                semaphore.acquire();

                System.out.println("No " + i + "乘客在检查");
                if(i % 2 == 0){
                    Thread.sleep(1000);
                    System.out.println("No " + i + "乘客可疑，扣下！");
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("No " + i + "结束安检啦");
            }

        }
    }
}


