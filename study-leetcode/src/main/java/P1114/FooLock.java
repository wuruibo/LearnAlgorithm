package P1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooLock {
    public static int FLAG_INT = 1;

    ReentrantLock reentrantLock = new ReentrantLock();

    Condition printedFirst = reentrantLock.newCondition();
    Condition printedSecond = reentrantLock.newCondition();


    public FooLock() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        reentrantLock.lock();
        System.out.println("first");
        FooLock.FLAG_INT = 2;
        printedFirst.signalAll();
        reentrantLock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        reentrantLock.lock();
        while (FooLock.FLAG_INT != 2) {
            printedFirst.await();
        }
        System.out.println("second");

        FooLock.FLAG_INT = 3;
        printedSecond.signalAll();
        reentrantLock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        reentrantLock.lock();
        while (FooLock.FLAG_INT != 3) {
            printedSecond.await();
        }
        System.out.println("third");
        //少了这句话会报错leetcode
        FooLock.FLAG_INT=4;
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        FooLock foo = new FooLock();
        new Thread(new ThreadCLock(foo)).start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new ThreadBLock(foo)).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new ThreadALock(foo)).start();
    }

}

class ThreadALock implements Runnable {
    private FooLock foo;

    public ThreadALock(FooLock foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.first(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadBLock implements Runnable {

    private FooLock foo;

    public ThreadBLock(FooLock foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.second(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadCLock implements Runnable {
    private FooLock foo;

    public ThreadCLock(FooLock foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.third(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}