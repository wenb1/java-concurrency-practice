package dev.wenbo.TIJ;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator{
    private int currentEvenValue=0;
    private Lock lock=new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try{
            ++currentEvenValue; //危险操作
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}