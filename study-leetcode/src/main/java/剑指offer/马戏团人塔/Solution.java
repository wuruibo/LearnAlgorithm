package 剑指offer.马戏团人塔;

import java.util.Arrays;

/**
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
 * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 示例：
 *
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：
 *
 * height.length == weight.length <= 10000
 *
 */
class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] persons=new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            int[] person=new int[]{height[i],weight[i]};
            persons[i]=person;
        }
        Arrays.sort(persons,(ints1,ints2)-> ints1[0]==ints2[0]?ints2[1]-ints1[1]:ints1[0]-ints2[0]);
        int[] dp=new int[height.length];
        int res=0;
        for (int i = 0; i < persons.length; i++) {
            int[] current=persons[i];
            int index=Arrays.binarySearch(dp,0,res,current[1]);
            if (index<0){
                index=-(index+1);
            }
            dp[index]=current[1];
            if (index==res) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bestSeqAtIndex(new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181},new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594}));
        System.out.println(new Solution().bestSeqAtIndex(new int[]{65,70,56,75,60,68}, new int[]{100,150,90,190,95,110}));
    }
}