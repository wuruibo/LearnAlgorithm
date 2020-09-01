package Contest.Contest26.Problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.如果某节点没有出现在可到达的节点集合
 *      a.说明该节点不能由其他节点到达
 *      b.那么该节点应该加入结果中
 * 2.如果某节点出现在可到达的节点集合
 *      a.那么无论该节点由其他哪个节点到达
 *      b.只要它能被到达即可，所以在结果集合中排除
 *
 */
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegrees = new int[n];
        for (List<Integer> edge : edges) {
            inDegrees[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

}