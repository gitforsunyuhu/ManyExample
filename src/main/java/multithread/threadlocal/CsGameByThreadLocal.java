package multithread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 通过CS游戏来说明ThreadLocal的作用：由于在cs游戏中，每个人都可以拿到同样数目的子弹，生命，同时杀敌人数初始都为0；
 * 我们希望每个人初始时的数据是一致的，但是每个人修改的时候是独立的，而ThreadLocal就是扮演这样的角色。
 * 初始值将会进入每个线程成为独立拷贝
 */
public class CsGameByThreadLocal  {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;

    //随机数用来展示每个对象的不同的数据
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    //初始化子弹数目
    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };

    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return LIFE_VALUE;
        }
    };

    private static class Player extends Thread {

        private String name;
        Player(String name){
            this.name = name;
        }

        @Override
        public void run() {
            Integer bullet = BULLET_NUMBER_THREADLOCAL.get() - 10;
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() + 10;
            Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() - 10;
            System.out.println(this.name + ", 子弹 ：" + bullet);
            System.out.println(this.name + ", 杀敌 ：" + killEnemies);
            System.out.println(this.name + ", 命数 ：" + lifeValue);
            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < TOTAL_PLAYERS; i++) {
//            new Player("第"+i + "个玩家").start();
//        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
