package dev.wenbo.TIJ.consumerproducer;

import java.util.*;

public class ConditionChange {
    public static List<String> lockObject=new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        Consumer consumer1 = new Consumer(lockObject);
        Consumer consumer2 = new Consumer(lockObject);
        Producer producer = new Producer(lockObject);
        consumer1.start();
        Thread.sleep(100);
        consumer2.start();
        Thread.sleep(100);
        producer.start();
    }

}
/**
 * 结果：
 * Thread-0 list为空
 * Thread-0 调用wait方法
 * Thread-1 list为空
 * Thread-1 调用wait方法
 * Thread-2 开始添加元素
 * Thread-1  wait方法结束
 * Thread-1 取出第一个元素为：Thread-2
 * Thread-0  wait方法结束
 * Exception in thread "Thread-0" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
 * 	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
 * 	at java.util.ArrayList.remove(ArrayList.java:496)
 * 	at dev.wenbo.TIJ.consumerproducer.Consumer.run(Consumer.java:23)
 */
