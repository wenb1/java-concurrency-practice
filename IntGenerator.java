package dev.wenbo.TIJ;

public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();

    //改变标识位
    public void cancel(){
        canceled=true;
    }
    //查看是否被取消
    public boolean isCanceled(){
        return canceled;
    }
}
