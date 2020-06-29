package dev.wenbo.TIJ;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable{
    private int countDown=5;
    private volatile double d;
    private int priority;
    private int id;

    public SimplePriorities(int priority, int id){
        this.priority=priority;
        this.id=id;
    }

    public void run(){
        Thread.currentThread().setPriority(priority);
        while (true){
            for(int i=1;i<100000;i++){
                d += (Math.PI + Math.E)/ (double) i;
                if(i%1000==0)
                    Thread.yield();
            }
            System.out.println("线程的id是： "+id+" 优先级是： "+priority);
            if(--countDown==0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY, i));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY, 5));
        exec.shutdown();
    }
}
