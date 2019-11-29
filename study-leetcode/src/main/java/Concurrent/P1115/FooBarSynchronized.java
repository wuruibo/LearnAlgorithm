package Concurrent.P1115;

/**
 * 通过synchronized锁释放/获取建立的happens-before关系
 *
 * @autor yeqiaozhu.
 * @date 2019-08-01
 */
public class FooBarSynchronized {


    private int n;
    //信号 0表示未打印foo 1表示已打印foo
    private int flag = 0;


    public FooBarSynchronized(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag == 1) {
                    this.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag == 0) {
                    this.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
                this.notifyAll();
            }
        }
    }
}
