package dev.wenbo.TIJ.consumerproducer;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car c){
        car=c;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                System.out.println("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax On task");
    }
}
