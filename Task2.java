package dev.wenbo.TIJ;

public class Task2 implements Runnable{
    static Blocker blocker=new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
