package Contest.Contest8.Problem4;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
class Solution {
    /*public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W!=0) {
            return false;
        }
        LinkedList<Integer> deque= new LinkedList<>();
        for (int i = 0; i < hand.length; i++) {
            deque.offer(hand[i]);
        }
        Collections.sort(deque);
        while (!deque.isEmpty()){
            Integer first=deque.pollFirst();
            for (int i = 1; i < W; i++) {
                if (!binarySearchDelete(deque,first+i,0,deque.size()-1)) {
                    return false;
                }
            }
        }
        return true;
    }*/


    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for (int num : nums) {
            minHeap.offer(num);
        }

        while (!minHeap.isEmpty()) {
            Integer top = minHeap.poll();

            for (int i = 1; i < k; i++) {
                // 从 1 开始，正好需要移除 k - 1 个元素
                // i 正好就是相对于 top 的偏移
                // 注意：这个 remove 操作会线性去扫 top + i 的索引，时间复杂度是 O(N)
                if (!minHeap.remove(top + i)) {
                    // 如果移除失败，说明划分不存在，直接返回 false 即可
                    return false;
                }
            }
        }
        return true;
    }


    private boolean binarySearchDelete(LinkedList<Integer> list,int target,int start,int end){
        while (start <= end) {
            int mid=start+((end-start)>>1);
            if (target>list.get(mid)) {
                start=mid+1;
            }else if (target<list.get(mid)){
                end=mid-1;
            }else {
                list.remove(mid);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPossibleDivide(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(new Solution().isPossibleDivide(new int[]{1,2,3,4,5}, 4));
    }
}