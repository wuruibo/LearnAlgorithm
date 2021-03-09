package Contest.Contest51.Problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
 * 输出：3
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
 * 1) 1 --> 2 --> 5
 * 2) 1 --> 2 --> 3 --> 5
 * 3) 1 --> 3 --> 5
 */
class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        //1.构建无向图
        Map<Integer, Set<Integer>> graphs= new HashMap<>(12);
        for (int[] edge : edges) {

        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        Integer size=10;
        System.out.println(objects.size()==size);
    }
}