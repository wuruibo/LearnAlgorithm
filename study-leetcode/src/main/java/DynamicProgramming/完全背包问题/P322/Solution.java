package DynamicProgramming.完全背包问题.P322;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
class Solution {
    private int minCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        quickSort(0,coins.length-1,coins);
        recursion(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    /**
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回
     */
    void recursion(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }
    private void quickSort(int start,int end,int[] array){
        if (start>=end) {
            return;
        }
        //排序
        int mark=start,privot=array[start],pointer=start;
        while (pointer<=end){
            if (array[pointer]<privot) {
                mark++;
                swap(pointer,mark,array);
            }
            pointer++;
        }
        swap(mark,start,array);
        quickSort(start,mark,array);
        quickSort(mark+1,end,array);
    }
    private void swap(int from,int to,int[] array){
        int temp=array[to];
        array[to]=array[from];
        array[from]=temp;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
    }
}