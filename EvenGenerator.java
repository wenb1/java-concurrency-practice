package dev.wenbo.TIJ;

public class EvenGenerator extends IntGenerator{
    private int currentEvenValue=0;

    @Override
    public synchronized int next() {
        ++currentEvenValue; //危险操作
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
/**结果：
 * Press control-c to exit
 * 385 not even!
 * 387 not even!
 * 383 not even!
 */