import LinkedList.AddTwoNumbers.ListNode;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @autor yeqiaozhu.
 * @date 2019-06-14
 */
public class Test {
    private static CountDownLatch countDownLatch=new CountDownLatch(5);

    private static AtomicReference<Integer> atomicReference=new AtomicReference<>(0);
    public static void digui(ListNode listNode){
        if(listNode.next==null){
            System.out.println(listNode.val);
            return;
        }
        digui(listNode.next);
        System.out.println(listNode.val);
    }
    public static void main(String[] args) {
/*        ListNode head=ListNodeUtils.createListNode(10,2);
        ListNodeUtils.printListNodes(head);

        digui(head);*/

        Map<String,AtomicReference<Integer>> map=new ConcurrentHashMap();
        map.put("key",atomicReference);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2, 15, 10,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    int j=50000;
                    AtomicReference<Integer> temp=map.get("key");
                    while (j>0) {
                        while (true) {
                            Integer oldValue=map.get("key").get();
                            Integer newValue = oldValue+ 1;
                            if(temp.compareAndSet(oldValue, newValue)){
                                j--;
                                break;
                            }
                        }
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(map.get("key").get());
        }
    }
}
