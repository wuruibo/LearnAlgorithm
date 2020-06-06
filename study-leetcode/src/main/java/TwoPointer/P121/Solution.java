package TwoPointer.P121;

/**
 * 买卖股票的最佳时机
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buyIndex=0;

        for (int i = 1; i < prices.length; i++) {
            int tempProfit=prices[i]-prices[buyIndex];
            //第一种情况 出现更大的收益
            if(tempProfit>maxProfit){
                maxProfit=prices[i]-prices[buyIndex];
            }else{
                if(prices[i]<prices[buyIndex]){
                    buyIndex=i;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] ints={7,6,4,3,1};
        System.out.println(new Solution().maxProfit(ints));
    }
}