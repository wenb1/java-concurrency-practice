package dev.wenbo.TIJ;

public class PrintTask implements Runnable{
    private String name;

    public PrintTask(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(name + "在运行");
        }
    }
}
