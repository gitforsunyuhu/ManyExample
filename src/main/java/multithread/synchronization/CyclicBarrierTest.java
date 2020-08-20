package multithread.synchronization;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 此类用于CyclicBarrier的示例
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier  = new CyclicBarrier(2);

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
                cyclicBarrier.await();
                System.out.println("-------开始：" + this.getName());
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
