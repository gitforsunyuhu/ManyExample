package multithread.synchronization;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 此类用于CyclicBarrier的示例
 * 这个类是提供了一个循环屏障，只有当所有线程都到达屏障的位置的时候才可以向下执行后续操作。
 * 比如 在玩游戏的时候，只有当某一方的所有玩家的血量都为0的时候，才开始下一轮新游戏。
 * 而在下一轮新游戏开始之前则可以使用 CyclicBarrier.await()方法来进行等待
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier  = new CyclicBarrier(8);

        for (int i = 0; i < 8; i++) {
            new TranslateThread(new String(""+i), cyclicBarrier).start();
        }

    }

    private static class TranslateThread extends Thread {

        private  String s;
        private final CyclicBarrier cyclicBarrier;
        public TranslateThread(String s, CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            this.s = s;
        }

        public void  run(){
            try {

                System.out.println("-------开始：" + this.getName());
                cyclicBarrier.await();
                //某种情况下，抛出异常
                if( Integer.parseInt(s) > 2){
                    System.out.println("有点异常");
                    Thread.sleep(1000);
                }
                System.out.println("no" + s + "完成");
            }catch (InterruptedException e){
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                cyclicBarrier.reset();
            }

        }
    }
}
