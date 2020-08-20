package multithread.tongxin;

import java.util.ArrayList;

/**
 * 模拟生产者和消费者模型
 * 实质上是使用了管程的思想来实现的
 */
public class TestPC {

    public static void main(String[] args) {
        Container container = new Container(10);

        Consumer consumer = new Consumer(container);
        Producer producer = new Producer(container);
        consumer.start();
        producer.start();
    }
}

//生产者
class Producer extends Thread{
    Container container;
    Producer(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < container.size; i++) {
            container.add(new Product(i + ""));
        }
    }
}

//消费者
class Consumer extends Thread{
    Container container;
    Consumer(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < container.size; i++) {
            container.get(new Product(i + ""));
        }
    }
}

// 仓库
class Container {
    //仓库的容量
    int size;
    ArrayList<Product> list;
    int count = 0;

    Container(int size){
        this.size = size;
        list = new ArrayList<>(size);
    }

    //添加商品
    public synchronized void add(Product product) {
        if(size == count){
            try {
                this.wait();
                System.out.println("生产这正在等待！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(product);
        count ++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产了产品" + product.id);
        this.notifyAll();
    }

    //取出商品
    public synchronized void get(Product product) {
        if(count == 0){
            try {
                this.wait();
                System.out.println("消费者正在等待！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i < list.size(); i++ ){
            if(list.get(i).id == product.id){
                list.remove(i);
                break;
            }
        }
        count --;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费了产品" + product.id);
        this.notifyAll();
    }
}

// 产品类
class Product {
    String id;
    Product(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }
}