package Stack.单调栈.P901;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class StockSpanner {
    private List<Integer> prices;
    private int i;
    private Deque<Integer> deque;
    public StockSpanner() {
        prices=new ArrayList<>();
        deque=new ArrayDeque<>();
        i=0;
    }

    public int next(int price) {
        while (!deque.isEmpty() && prices.get(deque.peekLast()) <= price) {
            deque.pollLast();
        }
        int result=deque.isEmpty()?i+1:i-deque.peekLast();
        deque.offerLast(i++);
        prices.add(price);
        return result;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner=new StockSpanner();
        int[] arrays=new int[]{100,80,60,70,60,75,85};
        int[] arrays1=new int[]{1,2,3,4,5,6,85};
        for (int array : arrays1) {
            System.out.println(stockSpanner.next(array));
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */