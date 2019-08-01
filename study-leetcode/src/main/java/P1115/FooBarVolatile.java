package P1115;

/**
 * 通过volatile写读建立的happens-before关系
 * @autor yeqiaozhu.
 * @date 2019-08-01
 */
public class FooBarVolatile {

    private int n;
    //信号 0表示未打印foo 1表示已打印foo
    private volatile int flag=0;


    public FooBarVolatile(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true){
                if(flag==0){
                    printFoo.run();
                    flag=1;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true){
                if(flag==1){
                    printBar.run();
                    flag=0;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }
}
