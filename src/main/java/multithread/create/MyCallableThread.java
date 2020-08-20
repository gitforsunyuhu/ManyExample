package multithread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableThread  {
    public static void main(String[] args) {
        //创建实现callable接口的对象
        MyCallable myCallable = new MyCallable();
        //将callable对象作为FutureTask的参数，创建FutureTask的对象
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        //将FutureTask对象作为参数创建Thread对象
        Thread thread = new Thread(futureTask);
        //调用线程对象的start方法
        thread.start();

        //通过FutureTask对象的get方法来获取返回值
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static class MyCallable implements Callable{

        @Override
        public String call() throws Exception {
            return "this is the callable thread";
        }
    }
}
