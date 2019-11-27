package TwoPointer.P122;

/**
 * 最大收益
 * 目测考察双指针 定义一个slow和一个fast指针
 * 当prices[slow] > prices[fast] slow=fast
 * tempMax=0;
 * 当prices[slow] < prices[fast] tempMax更新并且fast++;
 *
 *
 */
class Solution {
    public int maxProfit(int[] prices) {
        //定义双指针
        int slow=0,fast=1;
        //定义当前最大收益 和总的最大收益
        int tempMax=0,max=0;
        while (fast<prices.length){
            if (prices[fast-1]>prices[fast]) {
                max+=tempMax;
                tempMax=0;
                slow=fast;
            }else {
                tempMax=prices[fast]-prices[slow];
            }
            fast++;
        }
        max+=tempMax;
        return max;
    }

    public static void main(String[] args) {
        int[] ints={7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(ints));

        int[] ints1={1,2,3,4,5};
        System.out.println(new Solution().maxProfit(ints1));

        int[] ints2={7,6,4,3,1};
        System.out.println(new Solution().maxProfit(ints2));
    }
}