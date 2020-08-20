package multithread.state;

/**
 * 测试线程的状态
 *
 */


public class StateTest {
    public static void main(String[] args) {
        Thread a = new Thread(new StateThread());
        a.start();
        Thread.State state = a.getState();
        System.out.println(state);
    }
}

class StateThread implements  Runnable{
    @Override
    public void run() {
        System.out.println("aa");
    }
}
