package dev.wenbo.TIJ;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Thread waitThread=new WaitThread();
        waitThread.wait();
    }


}
