package 剑指offer.股票的最大利润;

public class NoSpace {
    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int max=0,start=prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>start) {
                max=Math.max(max,prices[i]-start);
            }else {
                start=prices[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new NoSpace().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new NoSpace().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new NoSpace().maxProfit(new int[]{}));
    }
}
