package Contest.Contest30.Problem2;

import java.util.Arrays;

/**
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 *
 * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 *
 * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 *
 * 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 *
 * x 与 u 的亲近程度胜过 x 与 y，且
 * u 与 x 的亲近程度胜过 u 与 v
 * 返回 不开心的朋友的数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
 * 输出：2
 * 解释：
 * 朋友 1 不开心，因为：
 * - 1 与 0 配对，但 1 与 3 的亲近程度比 1 与 0 高，且
 * - 3 与 1 的亲近程度比 3 与 2 高。
 * 朋友 3 不开心，因为：
 * - 3 与 2 配对，但 3 与 1 的亲近程度比 3 与 2 高，且
 * - 1 与 3 的亲近程度比 1 与 0 高。
 * 朋友 0 和 2 都是开心的。
 * 示例 2：
 *
 * 输入：n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
 * 输出：0
 * 解释：朋友 0 和 1 都开心。
 * 示例 3：
 *
 * 输入：n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
 * 输出：4
 *
 *
 * 提示：
 *
 * 2 <= n <= 500
 * n 是偶数
 * preferences.length == n
 * preferences[i].length == n - 1
 * 0 <= preferences[i][j] <= n - 1
 * preferences[i] 不包含 i
 * preferences[i] 中的所有值都是独一无二的
 * pairs.length == n/2
 * pairs[i].length == 2
 * xi != yi
 * 0 <= xi, yi <= n - 1
 * 每位朋友都 恰好 被包含在一对中
 */
class Solution {
    private int[][] hashPreferences;
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        //构造一个hash映射关系二维数组
        hashPreferences=new int[n][n-1];
        for (int i = 0; i < preferences.length; i++) {
            int[] hash=new int[n];
            for (int j = 0; j < preferences[i].length; j++) {
                int friend=preferences[i][j];
                hash[friend]=j;
            }
            hashPreferences[i]=hash;
        }
        boolean[] happy=new boolean[n];
        Arrays.fill(happy,true);
        //通过hash进行操作判断 每一对是否是happy的 循环判断
        for (int i = 0; i < pairs.length-1; i++) {
            int[] pairLeft=pairs[i];
            for (int j = i+1; j < pairs.length; j++) {
                int[] pairRight=pairs[j];
                int[][] circles={{pairLeft[0],pairLeft[1],pairRight[0],pairRight[1]}
                                ,{pairLeft[0],pairLeft[1],pairRight[1],pairRight[0]}
                                ,{pairLeft[1],pairLeft[0],pairRight[0],pairRight[1]}
                                ,{pairLeft[1],pairLeft[0],pairRight[1],pairRight[0]}
                                ,{pairRight[0],pairRight[1],pairLeft[0],pairLeft[1]}
                                ,{pairRight[0],pairRight[1],pairLeft[1],pairLeft[0]}
                                ,{pairRight[1],pairRight[0],pairLeft[0],pairLeft[1]}
                                ,{pairRight[1],pairRight[0],pairLeft[1],pairLeft[0]}};
                for (int k = 0; k < circles.length; k++) {
                    unhappy(circles[k],happy);
                }
            }
        }
        int result=0;
        for (int i = 0; i < happy.length; i++) {
            if (!happy[i]) {
                result++;
            }
        }
        return result;
    }

    /**
     * {0,1} {2,3}
     * @return
     */
    private void unhappy(int[] param,boolean[] happy){
        //找到x和u的亲密关系 和 x和y的亲密关系对比
        int x=param[0],y=param[1],u=param[2],v=param[3];
        if (happy[x]) {
            happy[x]=hashPreferences[x][u]>=hashPreferences[x][y] || hashPreferences[u][x]>=hashPreferences[u][v];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().unhappyFriends(4,new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][]{{0, 1}, {2, 3}}));
        System.out.println(new Solution().unhappyFriends(4,new int[][]{{1}, {0}}, new int[][]{{1, 0}}));
        System.out.println(new Solution().unhappyFriends(4,new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}}, new int[][]{{1, 3}, {0, 2}}));
        System.out.println(new Solution().unhappyFriends(4,new int[][]{{2,1,3},{0,3,2},{1,0,3},{2,0,1}}, new int[][]{{0,1},{2,3}}));
    }
}