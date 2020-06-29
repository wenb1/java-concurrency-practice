package dev.wenbo.TIJ.consumerproducer;

public class WaitThread extends Thread{
    private String lock;
    private Flag flag;

    public WaitThread(String lock, Flag flag){
        this.lock=lock;
        this.flag=flag;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(flag.isWait){
                System.out.println(Thread.currentThread().getName() + "  进去代码块");
                System.out.println(Thread.currentThread().getName() + "  开始wait");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "   结束wait");
            }
        }
    }
}
