package DynamicProgramming.P312;

import java.util.Arrays;

public class SolutionA {
    private int[] nums;
    private int[][] cache;
    public int maxCoins(int[] nums) {
        this.nums=nums;
        cache=new int[nums.length][nums.length];
        Arrays.stream(cache).forEach(ints -> Arrays.fill(ints,-1));
        return dfs(0,nums.length-1);
    }

    /**
     * 通过分治的方式
     * @param i
     * @param j
     * @return
     */
    private int dfs(int i,int j){
        if (i>j) {
            return 0;
        }
        if (cache[i][j]!=-1) {
            return cache[i][j];
        }
        int max=0;
        for (int k = i; k <= j; k++) {
            int left=i==0?1:nums[i-1];
            int right=j==nums.length-1?1:nums[j+1];
            int current=nums[k]*left*right;
            max=Math.max(max,current+dfs(i,k-1)+dfs(k+1,j));
        }
        cache[i][j]=max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionA().maxCoins(new int[]{3,1,5,8}));
        System.out.println(new SolutionA().maxCoins(new int[]{7,9,8,0,7,1,3,5,5,2}));
        System.out.println(new SolutionA().maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}));
    }
}
