package Stack.单调栈.P581;

/**
 * 这道题解决的是最长递增子序列
 * Input:2, 6, 4, 8, 10, 9, 15
 * Output:3
 * 采用递归解法
 */
class Solution {
    private int[] target;
    //初始默认以前一个位置为结尾的连续临时最大子串
    private int tempMax=0;
    public int findUnsortedSubarray(int[] nums) {
        this.target=nums;
        return findUnsortedSubarrayUsingRu(nums.length-1);
    }

    public int findUnsortedSubarrayUsingRu(int index){
        if (index==0) {
            return 1;
        }
        //返回子数组的最大连续递增
        int subMax=findUnsortedSubarrayUsingRu(index-1);
        if (target[index]>target[index-1]) {
            tempMax++;
        }else {
            tempMax=1;
        }
        return Math.max(subMax,tempMax);
    }

    public static void main(String[] args) {
        int[] ints={2, 6, 4, 8, 10, 9, 15};
        new Solution().findUnsortedSubarray(ints);
    }
}