
/**
 * @autor yeqiaozhu.
 * @date 2019-08-03
 */
package 解题群;

/**
 * 现有如下作业，作业的序号为i(1<=i<=1000000000)，现有线程数n(n>=1)，给定的策略是，序列号为i的作业只能在i%n线程上运行。
 * 为了避免资源冲突，每个线程再一次同步等待的过程中只能执行一条作业，且序号较小的作业被优先执行。
 *
 * 样例输入：第一行是要运行的作业序号i，不重复且用空格分隔，按照从小到大的顺序
 * 1 4 5 7
 * 4
 * 样例输出：输出执行的作业序号，从小到大排列
 * 1 4 5 7
 *
 *
 * solution 通过同步等待队列 在时间效率上更具备优势，没有被轮到的线程直接等待让出cpu时间片
 *
 * @autor yeqiaozhu.
 * @date 2019-08-03
 */
public class PrintUsingSynchronized {
    //记录当前要print的数值的数组索引位置，初始值为0 no need
    public static int index;
    //当前的线程数
    public static int threadNum;
    //当前的作业数组
    public static int[] array;
    //锁对象
    private static Object object = new Object();

    //输入初始化
    public PrintUsingSynchronized(int threadNum, int[] array) {
        this.threadNum = threadNum;
        this.array = array;
        this.index = 0;
        for (int i = 0; i < threadNum; i++) {
            new Thread(new PrintThreadSynchronized(i, object,"Working Thread-"+i)).start();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 7};
        new PrintUsingSynchronized(4, array);
    }

}

class PrintThreadSynchronized extends Thread {
    //加锁对象
    private Object object;

    private int threadId;

    public PrintThreadSynchronized(int threadId, Object object,String threadName) {
        super(threadName);
        this.threadId = threadId;
        this.object = object;
    }

    @Override
    public void run() {
        //System.out.println("get lock object");
        //volatile write happens-before volatile read
        synchronized (object) {
            while (PrintUsingSynchronized.index < PrintUsingSynchronized.array.length) {

                int currentValue = PrintUsingSynchronized.array[PrintUsingSynchronized.index];
                int threadNum = PrintUsingSynchronized.threadNum;

                while (currentValue % threadNum != threadId) {
                    try {
                        object.wait();
                        if(PrintUsingSynchronized.index >= PrintUsingSynchronized.array.length) {
                            return;
                        }
                        currentValue = PrintUsingSynchronized.array[PrintUsingSynchronized.index];

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程id---" + threadId + "输出的数值---" + PrintUsingSynchronized.array[PrintUsingSynchronized.index]);
                PrintUsingSynchronized.index++;
                object.notifyAll();
            }
        }
    }
}
