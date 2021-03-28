package Contest.Contest52.Problem2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        //1.采购单构建大顶堆 销售单构建小顶堆
        PriorityQueue<int[]> purchase=new PriorityQueue<>((ints1,ints2)->ints2[0]-ints1[0]);
        PriorityQueue<int[]> sale = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[0]));

        //2.循环遍历 加入到小顶堆和大顶堆中
        for (int i = 0; i < orders.length; i++) {
            int[] temp=orders[i];
            if (temp[2]==1) {
                //3.匹配到销售单 从采购单中匹配消除
                while (!purchase.isEmpty() && purchase.peek()[0]>=temp[0] && temp[1]>0){
                    int[] p=purchase.poll();
                    if (p[1]<temp[1]) {
                        temp[1]-=p[1];
                    }else if(p[1]>temp[1]) {
                        p[1]-=temp[1];
                        temp[1]=0;
                        purchase.offer(p);
                    }else {
                        p[1]-=temp[1];
                        temp[1]=0;
                    }
                }
                if (temp[1]>0) {
                    sale.offer(temp);
                }
            }else {
                //4.匹配到采购单 从销售单堆中剔除
                while (!sale.isEmpty() && sale.peek()[0] <= temp[0] && temp[1]>0) {
                    int[] s=sale.poll();
                    if (s[1]<temp[1]) {
                        temp[1]-=s[1];
                    }else if(s[1]>temp[1]) {
                        s[1]-=temp[1];
                        temp[1]=0;
                        sale.offer(s);
                    }else {
                        s[1]-=temp[1];
                        temp[1]=0;
                    }
                }
                if (temp[1]>0) {
                    purchase.offer(temp);
                }
            }
        }
        //5.归纳一共有几个
        long sum=0;
        while (!purchase.isEmpty()) {
            sum+=purchase.poll()[1];
            sum%=1000000007;
        }
        while (!sale.isEmpty()) {
            sum+=sale.poll()[1];
            sum%=1000000007;
        }
        return  (int) sum;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        //System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}));
        System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{{23,8,0},{28,29,1},{11,30,1},{30,25,0},{26,9,0},{3,21,0},{28,19,1},{19,30,0},{20,9,1},{17,6,0}}));
    }
}