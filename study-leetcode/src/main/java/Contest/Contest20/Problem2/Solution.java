package Contest.Contest20.Problem2;

import java.util.Arrays;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        long[] temp=new long[n*(n+1)/2+1];
        for (int i = 0,k=0; i < nums.length; i++) {
            int tempSum=0;
            for (int j = i; j < nums.length; j++) {
                tempSum+=nums[j];
                temp[k++]=tempSum;
            }
        }
        //排序
        Arrays.sort(temp);
        //统计前缀和
        for (int i = 1; i <= temp.length-1; i++) {
            temp[i]+=temp[i-1];
        }
        return (int)(temp[right]-temp[left-1])%((int)Math.pow(10,9)+7);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeSum(new int[]{1}, 1, 1, 1));
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10));
    }
}