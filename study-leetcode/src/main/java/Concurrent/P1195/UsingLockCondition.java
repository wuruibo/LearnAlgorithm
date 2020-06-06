package Concurrent.P1195;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-04
 */
public class UsingLockCondition {
    private int n;
    private int currentValue=1;

    ReentrantLock reentrantLock=new ReentrantLock();

    Condition condition=reentrantLock.newCondition();

    public UsingLockCondition(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < n/3-n/15; i++) {
            reentrantLock.lock();
            while(currentValue%3!=0 || currentValue%15==0){
                condition.await();
            }
            //执行打印fizz代码
            printFizz.run();
            currentValue++;
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 0; i < n/5-n/15; i++) {
            reentrantLock.lock();
            while (currentValue%5!=0 || currentValue%15==0){
                condition.await();
            }
            printBuzz.run();
            currentValue++;
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 0; i < n/15; i++) {
            reentrantLock.lock();
            while (currentValue%15!=0){
                condition.await();
            }
            printFizzBuzz.run();
            currentValue++;
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < (n-n/3-n/5+n/15); i++) {
            reentrantLock.lock();
            while (currentValue%5==0 || currentValue%3==0){
                condition.await();
            }
            printNumber.accept(currentValue);
            currentValue++;
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

}

