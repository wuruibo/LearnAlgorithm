package Concurrent.P1195;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
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
        while (true){
            if(currentValue<=n && currentValue%3==0 && currentValue%15!=0) {
                //执行打印fizz代码
                printFizz.run();
                ++currentValue;
            }
            Thread.sleep(1);
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true){
            if(currentValue<=n && currentValue % 5== 0 && currentValue % 15 != 0) {
                printBuzz.run();
                ++currentValue;
            }
            Thread.sleep(1);
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true){
            if(currentValue<=n && currentValue % 15==0){
                printFizzBuzz.run();
                ++currentValue;
            }
            Thread.sleep(1);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true){
            if(currentValue%3!=0 && currentValue % 5!=0){
                printNumber.accept(currentValue);
                ++currentValue;
            }
            Thread.sleep(1);
        }
    }

    public static void main(String[] args) {
        Queue<String> strings = new LinkedBlockingQueue<>();

        FizzBuzz fizzBuzz = new FizzBuzz(16);

        Thread t1, t2, t3, t4;

        (t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> strings.add("fizz"));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        (t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> strings.add("buzz"));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        (t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> strings.add("fizzbuzz"));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        (t4 = new Thread(() -> {
            try {
                fizzBuzz.number(number -> strings.add("" + number));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();


        try {
            t3.join();
            t4.join();
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
