package 剑指offer.数组中重复的数字;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0;i < nums.length ; i++){
            nums[i] = nums[i]+1;
        }
        int out = 0;
        for (int i = 0; i < nums.length ; i++) {
            //nums[i]可能为负(为负是因为这个下标对应的元素出现过了)，所以应该用绝对值表示
            int index = Math.abs(nums[i]);
            if (nums[index-1]<0){
                out = index-1;
                break;
            }
            nums[index-1] *= (-1) ;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatNumber(new int[]{4, 3, 1, 0, 2, 5, 3}));
    }
}