package dev.wenbo.TIJ;

public class MyThread extends Thread {
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++; //不同实例的id

    public MyThread(){
    }

    public MyThread(int countDown){
        this.countDown=countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
    }
    @Override
    public void run(){
        // run方法中一般都会有一个循环，有时是无限循环，等待被一些条件打断停止，否则会无限循环
        while (countDown-->0){
            System.out.println(status());
            Thread.yield(); //告诉线程调度器，这个线程已经完成任务了，CPU可以切换执行其它任务
        }
    }
}
