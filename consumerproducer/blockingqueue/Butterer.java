package dev.wenbo.TIJ.consumerproducer.blockingqueue;

public class Butterer implements Runnable{
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dry, ToastQueue buttered){
        dryQueue=dry;
        butteredQueue=buttered;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                Toast t=(Toast) dryQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Butterer off");
    }
}
