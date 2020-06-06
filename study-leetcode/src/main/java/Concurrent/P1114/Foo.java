package Concurrent.P1114;

/**
 * 利用volatile写读建立的happens-before关系保证可见性
 *
 */
class Foo {

    public static volatile int FLAG_INT=1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (true){
            if((Foo.FLAG_INT == 1) ){
                System.out.println("first");
                Foo.FLAG_INT=2;
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (true){
            if((Foo.FLAG_INT==2) ){
                System.out.println("second");
                Foo.FLAG_INT=3;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true){
            if((Foo.FLAG_INT== 3) ){
                System.out.println("third");
                Foo.FLAG_INT=4;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Foo foo=new Foo();
        new Thread(new ThreadC(foo)).start();

/*      try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        new Thread(new ThreadA(foo)).start();/*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        new Thread(new ThreadB(foo)).start();


    }

}

class ThreadA implements Runnable{
    private Foo foo;
    public ThreadA(Foo foo) {
        this.foo=foo;
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
class ThreadB implements Runnable{

    private Foo foo;
    public ThreadB(Foo foo) {
        this.foo=foo;
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
class ThreadC implements Runnable{
    private Foo foo;
    public ThreadC(Foo foo) {
        this.foo=foo;
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