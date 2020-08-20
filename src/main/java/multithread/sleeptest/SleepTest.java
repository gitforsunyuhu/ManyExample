package multithread.sleeptest;

import java.text.SimpleDateFormat;
import java.util.Date;

//通过sleep方法实现倒计时和当前时间
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        int ten = 10;
        downTime(10);
    }

    public static void downTime(int time) throws InterruptedException {
        while(time >= 0){
            Thread.sleep(1000);
            System.out.println(time);
            time --;
        }
    }

    public static void getCurrentTime() throws InterruptedException {
        Date startTime = new Date();
        while(true){

            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date();
        }
    }
}
