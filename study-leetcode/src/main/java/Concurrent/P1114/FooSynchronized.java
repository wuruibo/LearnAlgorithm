package Concurrent.P1114;

/**
 * @autor yeqiaozhu.
 * @date 2019-08-01
 */
public class FooSynchronized {

    public static int FLAG_INT=1;
    public FooSynchronized() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        //printFirst.run();
        System.out.println("first");
        FooSynchronized.FLAG_INT=2;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(FooSynchronized.FLAG_INT!=2){
            this.wait();
        }
        //printSecond.run();
        System.out.println("second");
        FooSynchronized.FLAG_INT=3;
        this.notifyAll();

    }

    public synchronized void  third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(FooSynchronized.FLAG_INT!=3){
            this.wait();
        }
        //printThird.run();
        System.out.println("third");
        //按道理不需要提交这句，因为已经执行完了，但是leetcode上不提交这句就会错误
        Foo.FLAG_INT=4;
    }
    /*public static void main(String[] args) {
        FooSynchronized foo = new FooSynchronized();
        new Thread(new ThreadCSync(foo)).start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new ThreadBSync(foo)).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new ThreadASync(foo)).start();
    }*/
}
class ThreadASync implements Runnable {
    private FooSynchronized foo;

    public ThreadASync(FooSynchronized foo) {
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

class ThreadBSync implements Runnable {

    private FooSynchronized foo;

    public ThreadBSync(FooSynchronized foo) {
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

class ThreadCSync implements Runnable {
    private FooSynchronized foo;

    public ThreadCSync(FooSynchronized foo) {
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
