package dev.wenbo.TIJ;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable newPrintTask=new PrintTask("Thread1");
        Runnable newPrintTask1=new PrintTask("Thread2");

        Thread t1=new Thread(newPrintTask);
        Thread t2=new Thread(newPrintTask1);

        t1.start();
        t1.join();
        t2.start();

    }
}
