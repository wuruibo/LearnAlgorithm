package Contest.Contest22.Problem2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * P1535
 */
class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> deque= new LinkedList<>();
        //将array加载进deque
        for (int i = 0; i < arr.length; i++) {
            deque.offerLast(arr[i]);
        }
        //模拟动作
        Integer first=deque.pollFirst(),count=k;
        while (count > 0) {
            if (first>deque.peekFirst()) {
                Integer current=deque.pollFirst();
                deque.offerLast(current);
                count--;
            }else {
                deque.offerLast(first);
                first=deque.pollFirst();
                count=k;
                count--;
            }
        }
        return first;
    }

    /**
     * 我们遍历数组维护一个最大值，并且统计他几次会被下一个最大值替换掉。也就相当于题目中的比较操作。
     * 如果有其中一个最大值替换次数 >= k 那么直接返回这个最大值。
     * 若遍历完成后无返回，由于数据保证游戏存在赢家，此时只要返回整个数组最大值就好。
     *
     * @param arr
     * @param k
     * @return
     */
    public int getWinnerOne(int[] arr, int k) {
        int win=arr[0],count=0;/*win:胜利者,count:获胜场次*/
        for(int i=1;i<arr.length&&count<k;i++){/*到达获胜场次跳出循环*/
            if(arr[i]<win){/*arr[i]比win小*的情况*/
                count++;
            }else{/*如果win输掉了产生新的胜利者，count置为1*/
                win=arr[i];
                count=1;
            }
        }
        return win;/*返回win*/
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(new Solution().getWinner(new int[]{3,2,1}, 10));
        System.out.println(new Solution().getWinner(new int[]{1,9,8,2,3,7,6,4,5}, 7));
        System.out.println(new Solution().getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000));
    }
}