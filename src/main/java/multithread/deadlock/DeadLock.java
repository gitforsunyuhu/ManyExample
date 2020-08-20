package multithread.deadlock;

/**
 * 模拟死锁操作
 * 死锁：两个或者多个线程分别拥有其他线程需要的锁，同时需要获取其他线程的锁
 * 如此形成僵持，就形成了死锁。
 *
 * 本实例中，两个小孩都想拥有对方的玩具
 */
public class DeadLock {
    public static void main(String[] args) {
        Child child1 = new Child("小明" , 0);
        Child child2 = new Child("小刚" , 1);
        child1.start();
        child2.start();
    }
}

//玩具一
class Toy1{
}
//玩具二
class Toy2{}
//儿童类，可以拥有玩具，以及play玩具
class Child extends Thread{
    static Toy1 toy1 = new Toy1();
    static Toy2 toy2 = new Toy2();

    String name;
    int childId;

    Child(String name, int childId){
        this.childId = childId;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play() throws InterruptedException {
        // 如果是第一个小孩，那么首先获取的是第一个玩具，之后获取第二个玩具
        if(childId == 0){
            synchronized (toy1){
                System.out.println(this.name + "获取到了第一个玩具");
                //玩了一会儿想要另外一个玩具
                Thread.sleep(1000);
//                synchronized (toy2){
//                    System.out.println(this.name + "获取到了第二个玩具");
//                }
            }
            synchronized (toy2){
                System.out.println(this.name + "获取到了第二个玩具");
            }
        }else{
            synchronized (toy2){
                System.out.println(this.name + "获取到了第二个玩具");
                //玩了一会儿想要另外一个玩具
                Thread.sleep(1000);
//                synchronized (toy1){
//                    System.out.println(this.name + "获取到了第一个玩具");
//                }
            }
            synchronized (toy1){
                System.out.println(this.name + "获取到了第一个玩具");
            }
        }
    }
}