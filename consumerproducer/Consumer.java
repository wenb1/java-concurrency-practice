package dev.wenbo.TIJ.consumerproducer;

import java.util.List;

public class Consumer extends Thread{
    private List<String> lock;

    public Consumer(List lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            try {
                //这里使用if的话，就会存在wait条件变化造成程序错误的问题
                while (lock.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " list为空");
                    System.out.println(Thread.currentThread().getName() + " 调用wait方法");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "  wait方法结束");
                }
                String element = lock.remove(0);
                System.out.println(Thread.currentThread().getName() + " 取出第一个元素为：" + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
