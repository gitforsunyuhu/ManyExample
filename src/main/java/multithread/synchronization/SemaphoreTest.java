package multithread.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * Semaphore示例
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
        private  final Semaphore semaphore;

        public SecurityCheckThread(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore =semaphore;
        }

        public void run(){
            try {
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
