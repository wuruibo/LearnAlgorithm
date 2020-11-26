package TwoPointer.P713;

/**
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int temp=1,result=0,i=0,j=0;
        while (i<nums.length || j<nums.length){
            //往右边滑动 滑到不能滑为止
            while (j<nums.length && temp*nums[j] < k) {
                temp*=nums[j++];
            }
            if (i==j) {//如果左边的滑到和右边相等的位置 直接跳到下一个位置
                j++;
                i++;
            }else {
                //先加一下当前i为起点的数量
                result += (j - i);
                //左边的指针开始往右滑动
                temp /= nums[i++];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{100, 5, 100, 6}, 100));
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}