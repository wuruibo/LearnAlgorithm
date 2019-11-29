package Concurrent.P1195;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int currentValue=1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < n/3-n/15; i++) {
            synchronized (FizzBuzz.class){
                while(currentValue%3!=0 || currentValue%15==0){
                    FizzBuzz.class.wait();
                }
                //执行打印fizz代码
                printFizz.run();
                currentValue++;
                FizzBuzz.class.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 0; i < n/5-n/15; i++) {
            synchronized (FizzBuzz.class){
                while (currentValue%5!=0 || currentValue%15==0){
                    FizzBuzz.class.wait();
                }
                printBuzz.run();
                currentValue++;
                FizzBuzz.class.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 0; i < n/15; i++) {
            synchronized (FizzBuzz.class){
                while (currentValue%15!=0){
                    FizzBuzz.class.wait();
                }
                printFizzBuzz.run();
                currentValue++;
                FizzBuzz.class.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < (n-n/3-n/5+n/15); i++) {
            synchronized (FizzBuzz.class){
                while (currentValue%5==0 || currentValue%3==0){
                    FizzBuzz.class.wait();
                }
                printNumber.accept(currentValue);
                currentValue++;
                FizzBuzz.class.notifyAll();
            }
        }
    }
}