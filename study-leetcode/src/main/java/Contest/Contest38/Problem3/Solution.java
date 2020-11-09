package Contest.Contest38.Problem3;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private Map<String,Integer> dpMap= new HashMap<>();

    /**
     * 解法二：二分查找
     * 我们可以二分查找 最后一次卖出时，球的价格 x。
     * 最后的答案由两部分组成：
     *
     * 对于所有数量 > x 的颜色，其肯定会减小到 x，因此用等差数列求和公式求和即可。
     * 如果执行完第 1 步，仍有剩余的 orders，则这些 orders 一定会以价格 x 卖出。
     * @param inventory
     * @param orders
     * @return
     */
    public int maxProfitBinary(int[] inventory, int orders) {
        long mod=1000000007;
        long s=1,e=1000000007;
        long ans=0;
        while(s<=e){
            long m=(s+e)/2;
            long c1=0,cnt=0;
            long r=0;
            for(int p:inventory){
                if(p>=m){
                    cnt++;
                    c1+=p-m+1;
                    r=(r+(p+m+1)*(p-m)/2)%mod;
                }
            }
            if(c1>=orders&&c1-cnt<orders){
                ans=r+(orders-c1+cnt)*m;
                break;
            }
            if(c1>=orders) {
                s=m;
            } else {
                e=m;
            }
        }
        return (int) ans;
    }


    /**
     * 用贪心的方式算一下
     * @param inventory
     * @param orders
     * @return
     */
    public int maxProfit(int[] inventory, int orders) {
        List<Integer> nums=Arrays.stream(inventory)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        long res = 0, mod = 1000000007;
        int j = 0;
        while(orders > 0) {
            while(j < nums.size() && nums.get(j) >= nums.get(0)) {
                ++j;
            }
            int next = 0;
            if(j < nums.size()) {
                next = nums.get(j);
            }
            long bucks = j, delta = nums.get(0) - next;
            long rem = bucks * delta;
            if(rem > orders) {
                long dec = orders / bucks;
                long a1 = nums.get(0) - dec + 1, an = nums.get(0);
                res += (((a1 + an) * dec) / 2) * bucks;
                res += (nums.get(0) - dec) * (orders % bucks);
            } else {
                long a1 = next + 1, an = nums.get(0);
                res += (((a1 + an) * delta) / 2) * bucks;
                nums.set(0,next);
            }
            orders -= rem;
            res %= mod;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfitBinary(new int[]{2, 5}, 4));
        System.out.println(new Solution().maxProfitBinary(new int[]{3, 5}, 6));
        System.out.println(new Solution().maxProfitBinary(new int[]{2,8,4,10,6}, 20));
        System.out.println(new Solution().maxProfitBinary(new int[]{1000000000}, 1000000000));

        System.out.println(new Solution().maxProfit(new int[]{2, 5}, 4));
        System.out.println(new Solution().maxProfit(new int[]{3, 5}, 6));
        System.out.println(new Solution().maxProfit(new int[]{2,8,4,10,6}, 20));
        System.out.println(new Solution().maxProfit(new int[]{1000000000}, 1000000000));
    }
}