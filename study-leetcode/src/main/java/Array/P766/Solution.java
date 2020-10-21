package Array.P766;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 *
 *
 *
 */
class Solution {
    /**
     * 首先要想明白的是怎么判断 (r1, c1 和 (r2, c2) 这两个点属于一条对角线。通过观察可以发现，在满足 r1 - c1 == r2 - c2 的情况下，这两个点属于同一条对角线。
     * 在上面的问题搞清楚的情况下，很容易就可以想到：让 groups[r-c] 存储每条对角线上遇到的第一个元素的值，如果之后遇到的任何一个值不等于之前存储的值，那么这个矩阵就不是托普利茨矩阵，否则就是。
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap(16);
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c)) {
                    groups.put(r-c, matrix[r][c]);
                } else if (groups.get(r-c) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 每个点都检查左上邻居是否和当前值相等 相等继续 不想等返回false
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrixLeftTop(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

}
