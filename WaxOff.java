package dev.wenbo.TIJ;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable{
    private Car car;

    public WaxOff(Car c){
        car=c;
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off task");
    }
}
