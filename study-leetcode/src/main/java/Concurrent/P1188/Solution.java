package Concurrent.P1188;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 设计一个有界阻塞队列
 * Design Bounded Blocking Queue
 * @autor yeqiaozhu.
 * @date 2019-10-08
 */
public class Solution {

    //定义一个队列
    private Queue<Integer> queue;
    //队列的capacity
    private Integer size;
    //定义一个lock
    private ReentrantLock reentrantLock=new ReentrantLock();

    //定义两个队列
    private Condition notEmpty=reentrantLock.newCondition();

    private Condition notFull=reentrantLock.newCondition();

    public Solution(Integer size) {
        this.queue=new LinkedList();
        this.size=size;
    }

    public void add(Integer integer) throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try {
            while (queue.size()==size){
                notFull.wait();
            }
            queue.add(integer);
            notEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public void remove() throws InterruptedException {
        reentrantLock.lockInterruptibly();

        try {
            while (queue.size()==0){
                notEmpty.wait();
            }
            queue.remove();
            notFull.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
