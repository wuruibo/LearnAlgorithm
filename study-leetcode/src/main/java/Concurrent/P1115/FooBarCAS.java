package Concurrent.P1115;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @autor yeqiaozhu.
 * @date 2019-08-01
 */
public class FooBarCAS {


        private int n;
        //信号 0表示未打印foo 1表示已打印foo
        private AtomicInteger flag=new AtomicInteger(0);



        public FooBarCAS(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!flag.compareAndSet(0,1)){
                    Thread.sleep(1);
                }
                printFoo.run();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!flag.compareAndSet(1,0)){
                    Thread.sleep(1);
                }
                printBar.run();
            }
        }

}
