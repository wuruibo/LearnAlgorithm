package Stack.P496;

import CommonUtils.StackUtils;

import java.util.*;

/**
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1==null) {
            return new int[]{};
        }
        Map<Integer,Integer> hashIndex= new HashMap<>();
        int[] result=new int[nums1.length];
        Deque<Integer> deque= new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            StackUtils.cutStack(nums2[i],hashIndex,deque);
        }

        while (deque.size() != 0) {
            Integer param=deque.pollLast();
            hashIndex.put(param,-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i]=hashIndex.get(nums1[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums1, nums2)));

        int[] nums3={2,4};
        int[] nums4={1,2,3,4};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums3, nums4)));
    }
}