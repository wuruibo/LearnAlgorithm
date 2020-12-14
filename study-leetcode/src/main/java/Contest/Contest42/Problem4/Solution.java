package Contest.Contest42.Problem4;

import java.util.Arrays;

class Solution {
    public int maxHeight(int[][] cuboids) {
        // 首先，将各个长方体数组内部的元素（即边长）从小到大进行排序
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        // 随后将整个长方体数组按照最短边长、次长边长、最长边长进行排序
        Arrays.sort(cuboids, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        // dp[i]表示【以第i个长方体为底】的【堆叠长方体】的最大高度
        int[] dp = new int[cuboids.length];
        int maxAns = 0;
        // 显然，我们需要找出可以放在第i个长方体上方的所有【堆叠长方体】的最大高度
        // 加上第i个长方体的高度，就可以得出【以第i个长方体为底】的【堆叠长方体】的最大高度
        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                // 虽然我们已经做了排序，但是还不能保证前面的长方体一定能够放在后面的长方体上方，只能保证后面的长方体一定不能放在前面的长方体上
                // 因此需要依次进行判断前面各个【堆叠长方体】能不能放置在第i个长方体上方，并找出前面各个【堆叠长方体】的最大高度的【最大值】
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += cuboids[i][2];
            // 更新所有【堆叠长方体】的最大高度
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}}));
    }
}