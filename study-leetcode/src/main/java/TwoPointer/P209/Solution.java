package TwoPointer.P209;

/**
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int sum=nums[0],min=Integer.MAX_VALUE,start=0,end=0;

        while (start<=end){
            if (sum>=s) {
                min=Math.min(min,end-start+1);
                sum-=nums[start++];
            }else {
                if (++end==nums.length) {break;}
                sum+=nums[end];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int[] ints={2};
        System.out.println(new Solution().minSubArrayLen(0,ints));
    }
}