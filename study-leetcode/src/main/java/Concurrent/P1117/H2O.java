package Concurrent.P1117;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class H2O {

    private ReentrantLock reentrantLock=new ReentrantLock();

    private int count=0;
    //define condition to signal O
    Condition conditionPrintedH=reentrantLock.newCondition();
    //define condition to signal H
    Condition conditionPrintedO=reentrantLock.newCondition();
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		reentrantLock.lock();
		while ((count%3)==2){
		    conditionPrintedO.await();
        }
		count++;
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        conditionPrintedH.signalAll();
        reentrantLock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        reentrantLock.lock();
        while ((count%3)!=2){
            conditionPrintedH.await();
        }
        count=0;
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		conditionPrintedO.signalAll();
		reentrantLock.unlock();
    }
}