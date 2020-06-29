package dev.wenbo.TIJ.consumerproducer;

public class EarlyNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        String lock="lock";
        Flag flag=new Flag();

        Thread waitThread=new WaitThread(lock, flag);
        Thread notifyThread=new NotifyThread(lock, flag);

        notifyThread.start();

        Thread.sleep(100);

        waitThread.start();
    }
}
