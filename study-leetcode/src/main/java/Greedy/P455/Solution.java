package Greedy.P455;

import java.util.Arrays;

class Solution {
    /**
     * 贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
     */
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        //第一步 先将饼干 和 孩子所需大小都进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        //当其中一个遍历就结束
        while (child < g.length && cookie < s.length ){
            //当用当前饼干可以满足当前孩子的需求，可以满足的孩子数量+1
            if (g[child] <= s[cookie]){
                child++;
            }
            cookie++; // 饼干只可以用一次，因为饼干如果小的话，就是无法满足被抛弃，满足的话就是被用了
        }
        return child; 
    }
}