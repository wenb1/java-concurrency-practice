package dev.wenbo.TIJ.consumerproducer.blockingqueue;

public class Jammer implements Runnable{
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue buttered, ToastQueue finished){
        butteredQueue=buttered;
        finishedQueue=finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t=(Toast) butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Jammer off");
    }
}
