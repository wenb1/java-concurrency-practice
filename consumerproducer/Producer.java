package dev.wenbo.TIJ.consumerproducer;

import java.util.List;

public class Producer extends Thread{
    private List<String> lock;

    public Producer(List lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + " 开始添加元素");
            lock.add(Thread.currentThread().getName());
            lock.notifyAll();
        }
    }
}
