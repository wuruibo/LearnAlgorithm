package P494;

/**
 * 递归解决O(N^2)
 */
class Solution {
    private int[] nums;
    public int findTargetSumWays(int[] nums, int S) {
        this.nums=nums;
        return findTargetSumWaysIndex(nums.length-1,S);
    }
    public int findTargetSumWaysIndex(int index,int S){
        if (index==0) {
            if (nums[index]==0 && S==0) {
                return 2;
            }
            return Math.abs(S)==Math.abs(nums[index])?1:0;
        }
        return findTargetSumWaysIndex(index-1,S-nums[index])+findTargetSumWaysIndex(index-1,S+nums[index]);
    }

    public static void main(String[] args) {
        int[] ints={0,0,0,0,0,0,0,0,1};
        new Solution().findTargetSumWays(ints,1);
    }
}