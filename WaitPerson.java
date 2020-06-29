package dev.wenbo.TIJ;

public class WaitPerson implements Runnable{
    private Restaurant restaurant;
    public WaitPerson(Restaurant r){
        restaurant=r;
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.meal==null)
                        wait();
                }
                System.out.println("WaitPerson got "+restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal=null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
