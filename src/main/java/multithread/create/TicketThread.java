package multithread.create;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;

public class TicketThread implements Runnable{
    private int ticket = 10;

    @Override
    public synchronized void run() {
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "; ticket = " + ticket);
            ticket --;
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread, "老师").start();
        new Thread(ticketThread,"黄牛").start();
        new Thread(ticketThread, "学生").start();
    }
}
