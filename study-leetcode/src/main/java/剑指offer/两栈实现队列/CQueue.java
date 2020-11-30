package 剑指offer.两栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    private Deque<Integer> support;
    private Deque<Integer> main;

    public CQueue() {
        support=new LinkedList<>();
        main=new LinkedList<>();
    }
    
    public void appendTail(int value) {
        support.offerLast(value);
    }
    
    public int deleteHead() {
        if (main.isEmpty()) {
            while (!support.isEmpty()) {
                main.offerLast(support.pollLast());
            }
        }
        return main.isEmpty()?-1:main.pollLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */