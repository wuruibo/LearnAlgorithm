package Array.P414;

import java.util.*;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
class Solution {
    public int thirdMax(int[] nums) {
        //set去重
        Set<Integer> set= new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
        Queue<Integer> priority=new PriorityQueue<>();
        Iterator<Integer> iterator=set.iterator();
        if (set.size()<3) {
            Integer max=Integer.MIN_VALUE;
            while (iterator.hasNext()){
                Integer current=iterator.next();
                max=Math.max(max,current);
            }
            return max;
        }
        while (iterator.hasNext()) {
            Integer integer=iterator.next();

            if (priority.size()<3) {
                priority.offer(integer);
            }else {
                if (priority.peek()<integer) {
                    priority.poll();
                    priority.offer(integer);
                }
            }
        }

        return priority.peek();
    }

    public static void main(String[] args) {
        int[] ints={2, 2, 3, 1};
        int[] ints1={2, 1};
        System.out.println(new Solution().thirdMax(ints));
        System.out.println(new Solution().thirdMax(ints1));
    }
}