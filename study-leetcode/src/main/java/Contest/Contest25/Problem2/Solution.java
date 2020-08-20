package Contest.Contest25.Problem2;

import java.util.HashMap;
import java.util.Map;

/**
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 *
 * 吃掉一个橘子。
 * 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 * 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 * 每天你只能从以上 3 种方案中选择一种方案。
 *
 * 请你返回吃掉所有 n 个橘子的最少天数。
 */
class Solution {
    public int minDays(int n) {
        //表示吃掉i个橘子需要花多少天
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(0,0);
        for (int i = 1; i <= n; i++) {
            int temp=hash.get(i-1)+1;
            if (i%2==0) {
                temp=Math.min(hash.get(i/2)+1,temp);
            }
            if (i%3==0) {
                temp=Math.min(hash.get(i-2*(i/3))+1,temp);
            }
            hash.put(i,temp);
        }
        return hash.get(n);
    }
    public int minDays1(int n){
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(0,0);
        return recursive(n,hash);
    }
    private int recursive(int n, Map<Integer,Integer> hash){
        if (n == 1) {
            return 1;
        } else if (n <= 3) {
            return 2;
        }
        if (hash.containsKey(n)) {
            return hash.get(n);
        }
        int temp=recursive(n-1,hash)+1;
        if (n%2==0) {
            temp=Math.min(recursive(n/2,hash)+1,temp);
        }
        if (n%3==0) {
            temp=Math.min(recursive(n-2*(n/3),hash)+1,temp);
        }
        hash.put(n,temp);
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(9209408));
        System.out.println(new Solution().minDays(6));
        System.out.println(new Solution().minDays(1));
        System.out.println(new Solution().minDays(56));

        System.out.println(new Solution().minDays1(9209408));
        System.out.println(new Solution().minDays1(6));
        System.out.println(new Solution().minDays1(1));
        System.out.println(new Solution().minDays1(56));
    }
}