package DepthFirstSearch.P638;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 */
class Solution {
    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 将原价物品也打包成大礼包，方便处理
        for(int i = 0; i < price.size(); i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < price.size(); j++){
                if(j != i)
                    list.add(0);
                else
                    list.add(1);
            }
            list.add(price.get(i));
            special.add(list);
        }

        // 将needs全为0状态放入
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < needs.size(); i++) {
            list.add(0);
        }
        memo.put(list, 0);

        return helper(special, needs);
    }

    public int helper(List<List<Integer>> special, List<Integer> needs) {
        if(memo.containsKey(needs))
            return memo.get(needs);

        int i;
        int cost = (int)1e8;
        for(List<Integer> list : special){
            // k为最多购买k件当前大礼包
            int k = (int)1e8;
            for(i = 0; i < list.size()-1; i++){
                if(list.get(i) != 0){
                    k = Math.min(k, needs.get(i) / list.get(i));
                }
            }
            // 如果当前礼包无法购买，考虑下一个礼包
            if(k == 0) {
                continue;
            }

            // 购买k件当前大礼包
            List<Integer> temp = new ArrayList<>();
            for(i = 0; i < list.size() - 1; i++) {
                temp.add(needs.get(i) - k * list.get(i));
            }
            cost = Math.min(cost, helper(special, temp) + k * list.get(i));
        }

        // 记忆
        memo.put(needs, cost);
        return cost;
    }


    public static void main(String[] args) {
        int[] price={2,3,4};
        int[][] special={{1,1,0,4},{2,2,1,9}};
        int[] needs={1,2,1};
        List<Integer> prices=Arrays.stream(price).boxed().collect(Collectors.toList());
        List<Integer> needss=Arrays.stream(needs).boxed().collect(Collectors.toList());
        List<List<Integer>> specials=Arrays.stream(special)
                .map(ints -> Arrays.stream(ints)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(new Solution().shoppingOffers(prices, specials,needss));
    }
}