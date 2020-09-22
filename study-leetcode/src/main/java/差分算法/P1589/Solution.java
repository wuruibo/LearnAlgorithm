package 差分算法.P1589;

import java.util.Arrays;

/**
 * 比如一个区间 [10, 15], 那么这个区间从 10 开始往后都是累加1，直到 15，所以超过 15 时就 -1 表示这个区间统计结束。
 *
 * 比如 0 ~ 20 之间只有两个区间 [8, 12][10, 15]，我们定义一个统计数的数组，那么 8，10 为 两区间开始，那么值就为 1，12 和 15 为两个区间的结束，
 * 那么值就为 -1，从 0 累加这个统计数组，到8 （值为1）时表示开始一个区间，加1，到10 （值为1）时表示又开始一个区间，再加1，就等于2了，
 * 然后到 12（值为-1） 结束一个区间，减去1，就等于1了，最后到 15（值为-1），再结束一个区间，减去1，就是这样... 写的有点乱
 */
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests){
        //nums数组的差分序列
        int[] dnums = new int[nums.length];
        dnums[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dnums[i]=nums[i]-nums[i-1];
        }
        
        //遍历所有的区间，用差分来记录区间的权重
        //也就是每个位置，要被查询到的次数，查询一次就+1
        for(int i=0;i<requests.length;i++){
            //开始
            dnums[requests[i][0]]++;
            if(requests[i][1]<dnums.length-1){
                dnums[requests[i][1]+1]--;
            }
            
        }
        
        //前缀和将差分数组恢复至未差分前的状态
        for(int i = 1;i<dnums.length;i++){
            dnums[i]+=dnums[i-1];
        }
        //对计算后的数组dnums和原数组对比，最后得出查询数组对于每个位置的查询次数。
        for(int i = 0;i<nums.length;i++){
            dnums[i] = dnums[i]-nums[i];
        }
        
        Arrays.sort(dnums);
        Arrays.sort(nums);
        
        long sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum += dnums[i]*nums[i];
        }
        return (int)(sum%1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 1}}));
    }
}
