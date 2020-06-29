package dev.wenbo.TIJ.consumerproducer.blockingqueue;

public class Eater implements Runnable{
    private ToastQueue finishedQueue;
    private int counter=0;

    public Eater(ToastQueue finished){
        finishedQueue=finished;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                Toast t=(Toast) finishedQueue.take();
                if(t.getId()!=counter++||t.getStatus()!=Toast.Status.JAMMED){
                    System.out.println(">>>>>Error: "+t);
                    System.exit(1);
                }else
                    System.out.println("Chomp! "+t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Eater off");
    }
}
