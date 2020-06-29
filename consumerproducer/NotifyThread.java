package dev.wenbo.TIJ.consumerproducer;

public class NotifyThread extends Thread{
    private String lock;
    private Flag flag;

    public NotifyThread(String lock, Flag flag){
        this.lock=lock;
        this.flag=flag;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + "  进去代码块");
            System.out.println(Thread.currentThread().getName() + "  开始notify");
            lock.notify();
            flag.isWait=false;
            System.out.println(Thread.currentThread().getName() + "  结束开始notify");
        }
    }
}
