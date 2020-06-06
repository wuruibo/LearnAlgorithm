package 解题群;

/**
 *
 *
 * solution 通过volatile写/读具备锁的内存语义 cpu空转资源消耗大但是写法更简单易于理解。
 * @autor yeqiaozhu.
 * @date 2019-08-03
 */
public class PrintThread {
    //记录当前要print的数值的数组索引位置，初始值为0
    public static volatile int index;
    //当前的线程数
    public static int threadNum;
    //当前的作业数组
    public static int[] array;
    //输入初始化
    public PrintThread(int threadNum,int[] array) {
        this.threadNum=threadNum;
        this.array=array;
        this.index=0;
        for(int i=0;i<threadNum;i++){
            new Thread(new PrintThreadClass(i)).start();
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,4,6,7};
        new PrintThread(4,array);
    }

}
class PrintThreadClass implements Runnable{

    private int threadId;

    public PrintThreadClass(int threadId) {
        this.threadId=threadId;
    }

    @Override
    public void run() {
        //volatile write happens-before volatile read
        while (true){
            if(PrintThread.index==(PrintThread.array.length)){
                break;
            }
            if((PrintThread.array[PrintThread.index]%PrintThread.threadNum)== threadId){
                System.out.println("当前线程id---"+threadId+"输出的数值---"+PrintThread.array[PrintThread.index]);
                PrintThread.index++;
            }
        }
    }
}
