package Greedy.跳跃游戏.P55;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 *
 *
 *
 * 题解：
 * 假设我们站在起点上，每次到达下一个节点都看看自己身上还剩下的能量是不是大于当前节点的能量 如果大于就不捡起来否则捡起新的能量继续跳
 * 如果没有能量继续往前跳了 代表失败否则跳到结尾就算成功
 */
class Solution {
    public boolean canJump(int[] nums) {
        int energy=0;
        for (int i = 0; i < nums.length; i++) {
            energy=Math.max(nums[i],energy);
            if (energy--==0 && i!=nums.length-1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}