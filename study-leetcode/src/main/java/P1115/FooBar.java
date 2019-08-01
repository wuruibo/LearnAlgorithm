package P1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过lock-condition建立的happens-before关系
 */
class FooBar {

    private int n;
    //信号 0表示未打印foo 1表示已打印foo
    private int flag=0;
    ReentrantLock reentrantLock= new ReentrantLock();
    Condition fooPrintedCondition=reentrantLock.newCondition();
    Condition barPrintedCondition=reentrantLock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            while (flag ==1){
                barPrintedCondition.await();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            flag=1;
            fooPrintedCondition.signalAll();
        	reentrantLock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            while (flag==0){
                fooPrintedCondition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            flag=0;
        	barPrintedCondition.signalAll();
        	reentrantLock.unlock();
        }
    }
}