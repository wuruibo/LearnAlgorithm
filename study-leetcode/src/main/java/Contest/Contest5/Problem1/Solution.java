package Contest.Contest5.Problem1;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] result=new int[nums.length];
        int tempSum=0;
        for (int i = 0; i < nums.length; i++) {
            result[i]=(tempSum+=nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4};
        new Solution().runningSum(a);

        int[] b={1,1,1,1,1};
        new Solution().runningSum(b);

        int[] c={3,1,2,10,1};
        new Solution().runningSum(c);
    }
}