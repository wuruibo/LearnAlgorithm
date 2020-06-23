package BinarySearch.P300;

/**
 * 最长上升子序列
 *
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] binaryArray=new int[nums.length];
        int end=-1;
        for (int num : nums) {
            int index=binarySearch(binaryArray,0,end,num);
            if (index>end) {
                end=index;
            }
            binaryArray[index]=num;
        }
        return end+1;
    }
    private int binarySearch(int[] array,int start,int end,int target){
        while (start<=end){
            int mid=start+((end-start)>>1);
            if (target>array[mid]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] test={2,2};
        System.out.println(new Solution().lengthOfLIS(test));
    }
}