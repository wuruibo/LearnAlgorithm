package Stack.单调栈.栈排序;

import java.util.Deque;
import java.util.LinkedList;

class SortedStack {
    /**
     * 最小栈 单调递减
     */
    Deque<Integer> minDeque= new LinkedList<>();
    Deque<Integer> tempDeque=new LinkedList<>();
    public SortedStack() {

    }
    
    public void push(int val) {
        while (!minDeque.isEmpty() && val > minDeque.peekLast()) {
            tempDeque.offerLast(minDeque.pollLast());
        }
        minDeque.offerLast(val);
        //将辅助栈中数据添加进minDeque中
        while (!tempDeque.isEmpty()) {
            minDeque.offerLast(tempDeque.pollLast());
        }
    }
    
    public void pop() {
        if (!minDeque.isEmpty()) {
            minDeque.pollLast();
        }
    }
    
    public int peek() {
        return minDeque.isEmpty()?-1:minDeque.peekLast();
    }
    
    public boolean isEmpty() {
        return minDeque.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */