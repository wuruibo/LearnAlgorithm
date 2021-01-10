package Contest.Contest48.Problem3;

import java.util.*;

/**
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 */
class Solution {
    private int[] parents;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        //构建并查集
        parents=new int[source.length];
        //初始化
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }
        for (int i = 0; i < allowedSwaps.length; i++) {
            union(allowedSwaps[i][0],allowedSwaps[i][1]);
        }
        //构建target的位置map key为target的值 value的index
        Map<Integer, List<Integer>> targetMap= new HashMap<>(16);
        for (int i = 0; i < target.length; i++) {
            targetMap.putIfAbsent(target[i], new ArrayList<>());
            targetMap.get(target[i]).add(i);
        }
        int count=0;
        //开始source的匹配 匹配到target中的元素 如果在一个连通分量中 可以调换
        for (int i = 0; i < source.length; i++) {
            if (!targetMap.containsKey(source[i])) {
                count++;
                continue;
            }
            List<Integer> targetList=targetMap.get(source[i]);
            Iterator<Integer> iterator=targetList.iterator();
            boolean flag=false;
            while (iterator.hasNext()) {
                int targetValue=iterator.next();
                if (connected(targetValue,i)) {
                    iterator.remove();
                    flag=true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }
    private void union(int l,int r){
        int left=find(l);
        int right=find(r);
        parents[left]=right;
    }
    private int find(int target){
        while (parents[target] != target) {
            target=parents[target];
        }
        return target;
    }
    private boolean connected(int left,int right){
        return find(left)==find(right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5}, new int[][]{{0, 1}, {2, 3}}));
        System.out.println(new Solution().minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{1,2,3,4}, new int[][]{}));
        System.out.println(new Solution().minimumHammingDistance(new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,4},{4,2},{1,3},{1,4}}));
    }
}