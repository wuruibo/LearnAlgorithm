package P1195;

import java.util.function.IntConsumer;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-04
 */
public class UsingVolatile {
    private int n;
    private volatile int currentValue=1;

    public UsingVolatile(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (currentValue<=n){
            if(currentValue%3!=0 || currentValue%15==0) {
                continue;
            }
            //执行打印fizz代码
            printFizz.run();
            currentValue++;
            Thread.sleep(1);
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentValue<=n){
            if(currentValue%5!=0 || currentValue%15==0) {
                continue;
            }
            printBuzz.run();
            currentValue++;
            Thread.sleep(1);
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentValue<=n){
            if(currentValue%15!=0) {
                continue;
            }
            printFizzBuzz.run();
            currentValue++;
            Thread.sleep(1);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (currentValue<=n){
            if(currentValue%5==0 || currentValue%3==0) {
                continue;
            }
            printNumber.accept(currentValue);
            currentValue++;
            Thread.sleep(1);
        }
    }
}
