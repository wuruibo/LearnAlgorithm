package 剑指offer.最接近目标价格的甜点成本;

class Solution {
    private int distance=Integer.MAX_VALUE;
    private int closestCost=Integer.MAX_VALUE;
    private int[] times=new int[]{0,1,2};
    private int[] toppingCosts;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.toppingCosts=toppingCosts;
        for(int i=0;i<baseCosts.length;i++){
            dfs(baseCosts[i],target,0);
        }
        return closestCost;
    }
    private void dfs(int tempTarget,int target,int index){
        //计算距离
        //System.out.println(tempTarget+"-"+target+"-"+index);
        if (Math.abs(tempTarget-target)<distance){
            distance=Math.min(distance,Math.abs(tempTarget-target));
            closestCost=tempTarget;
        }
        if (toppingCosts.length>index) {
            for (int i = 0; i < times.length; i++) {
                int nextTempTarget=tempTarget+toppingCosts[index]*times[i];
                dfs(nextTempTarget,target,index+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
        System.out.println(new Solution().closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
        System.out.println(new Solution().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
        System.out.println(new Solution().closestCost(new int[]{10}, new int[]{1}, 1));
        System.out.println(new Solution().closestCost(new int[]{4}, new int[]{9}, 9));
    }

}