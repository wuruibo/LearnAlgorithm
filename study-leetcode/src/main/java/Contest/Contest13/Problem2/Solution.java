package Contest.Contest13.Problem2;

/**
 * 记录前缀数字出现频次，满足题意的频次分布为：(记max为最大频次)
 * 1.max,max-1,max-1... 一个频次为max,其他频次全为max-1;
 * 2.1,max,max,max... 一个频次为1，其他频次全为max,max可以为1
 */
class Solution {
    // 最大相等频率.java
    public int maxEqualFreq(int[] nums) {
        int len = nums.length;
        int []sub = new int[100001];
        int []pre = new int[100001];
        int res = 0;
        int cur = 0;
        for(int i=0;i<len;i++){
            pre[++sub[nums[i]]]++;
            cur = Math.max(sub[nums[i]],cur);
            if(pre[cur]==1 && pre[cur-1] * (cur-1)+1 == (i+1) || (pre[cur]*cur+1==i+1)){
                res=i+1;
            }
        }
        if(cur == 1) return nums.length;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
        System.out.println(new Solution().maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        System.out.println(new Solution().maxEqualFreq(new int[]{1,1,1,2,2,2}));
    }
}