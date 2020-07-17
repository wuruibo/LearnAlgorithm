package Contest.Contest11.Problem3;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
            return  false;
        //定义两个指针
        int min = Integer.MAX_VALUE ;//第一个数的最小值
        int mid = Integer.MAX_VALUE ;//中间数
        for(int i = 0 ;i < nums.length;i++){
            if(nums[i] <= min ){
                min = nums[i];
            }else if(nums[i] <= mid){
                mid = nums[i];//当mid被赋值后，证明i前面一点存在比mid小的值，并且这个mid是比min大的值中最小的一个
            }else {
                return true;//那么当出现比mid大的数后，说明存在三个数为递增序列
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}));
    }
}