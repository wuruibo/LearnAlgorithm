package DynamicProgramming.P714;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 交易价格变化
     */
    private int[] prices;
    /**
     * 交易手续费
     */
    private int fee;
    private int boughtValue=-1;
    private Map<String,Integer> dpMap= new HashMap<>();
    public int maxProfit(int[] prices, int fee) {
        this.prices=prices;
        this.fee=fee;
        return dfs(0,0);
    }

    private int dfs(int i,int bought){
        String key= Arrays.stream(new int[]{i, bought})
                .boxed()
                .map(String::valueOf)
                .reduce((a,b)->a+"-"+b)
                .get();
        if (i>prices.length-1) {
            return 0;
        }
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        //当前位置可以选择买还是不买 考虑买入
        int result=0;
        if (bought==0) {
            this.boughtValue=prices[i];
            int boughtMax=dfs(i+1,bought^1);
            int notBoughtMax=dfs(i+1,bought);
            result=Math.max(boughtMax,notBoughtMax);
        }else if (bought==1){//当前位置可以选择卖还是不卖 考虑卖出
            //先计算在这里卖出的话能赚多少
            int profit=prices[i]-this.boughtValue-fee;
            int soldMax=dfs(i+1,bought^1)+profit;
            int notSoldMax=dfs(i+1,bought);
            result=Math.max(soldMax,notSoldMax);
        }
        dpMap.put(key,result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        /*System.out.println(new Solution().maxProfit(new int[]{1,3,7,5,10,3}, 3));
        System.out.println(new Solution().maxProfit(new int[]{1}, 2));*/
    }
}