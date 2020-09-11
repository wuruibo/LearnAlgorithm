package BFS.P1197;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。
 *
 * 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格。
 *
 * 每次移动，他都可以按图示八个方向之一前进。
 *
 * 现在，骑士需要前去征服坐标为 [x, y] 的部落，请你为他规划路线。
 *
 * 最后返回所需的最小移动次数即可。本题确保答案是一定存在的。
 *
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 1
 * 输出：1
 * 解释：[0, 0] → [2, 1]
 * 示例 2：
 *
 * 输入：x = 5, y = 5
 * 输出：4
 * 解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *  
 *
 * 提示：
 *
 * |x| + |y| <= 300
 *
 */
class Solution {
    /**
     * 定义八个方向 每个位置都对应八种跳法
     */
    private int[][] directs=new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue=new LinkedList<>();
        //需要做一下减枝
        int[][] visited=new int[601][601];
        int[] root=new int[]{300,300};
        queue.add(root);
        visited[300][300]=1;
        int level=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[] current=queue.poll();
                if (current[0]==(x+300) && current[1]==(y+300)) {
                    return level;
                }
                //继续添加元素
                for (int j = 0; j < directs.length; j++) {
                    int[] next=new int[2];
                    next[0]=current[0]+directs[j][0];
                    next[1]=current[1]+directs[j][1];
                    double circle=Math.sqrt((next[0]-300)*(next[0]-300)+(next[1]-300)*(next[1]-300));
                    if (circle<=300 && visited[next[0]][next[1]]==0) {
                        queue.offer(next);
                        visited[next[0]][next[1]]=1;
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minKnightMoves(2, 1));
        System.out.println(new Solution().minKnightMoves(5, 5));
        System.out.println(new Solution().minKnightMoves(2, 112));
        System.out.println(new Solution().minKnightMoves(300, 0));
        System.out.println(new Solution().minKnightMoves(0, -300));
    }
}