package Array.前缀和.P1423;

/**
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。
 * 最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 *
 * 找到长度为固定值并且和最小的子数组
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //确定目标子数组的长度
        int length=cardPoints.length;
        int target=length-k,min=Integer.MAX_VALUE;
        int[] pre=new int[length+1];
        for (int i = 1; i < pre.length; i++) {
            pre[i]=pre[i-1]+cardPoints[i-1];
            int preIndex=i-target;
            if (preIndex>=0) {
                min=Math.min(min,pre[i]-pre[preIndex]);
            }
        }
        return pre[length]-min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{1}, 1));
        System.out.println(new Solution().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(new Solution().maxScore(new int[]{2,2,2}, 2));
        System.out.println(new Solution().maxScore(new int[]{9,7,7,9,7,7,9}, 7));
        System.out.println(new Solution().maxScore(new int[]{1,1000,1}, 1));
        System.out.println(new Solution().maxScore(new int[]{1,79,80,1,1,1,200,1}, 3));
    }
}