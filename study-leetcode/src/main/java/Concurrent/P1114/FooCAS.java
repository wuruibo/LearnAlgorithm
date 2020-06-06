package Concurrent.P1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用cas的happens-before规则
 * @autor yeqiaozhu.
 * @date 2019-08-01
 */
public class FooCAS {


    AtomicInteger count = new AtomicInteger();

    public FooCAS() {
        count.set(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        while (!count.compareAndSet(0, 1)) {
            // printFirst.run() outputs "first". Do not change or remove this line.
        }
        printFirst.run();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!count.compareAndSet(1, 2)) {
            // printSecond.run() outputs "second". Do not change or remove this line.
        }
        printSecond.run();

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!count.compareAndSet(2, 3)) {
            // printThird.run() outputs "third". Do not change or remove this line.
        }
        printThird.run();

    }

}
