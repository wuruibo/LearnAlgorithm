package Contest.Contest47.Problem1;

import java.util.Arrays;

/**
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 */
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(ints1,ints2)->ints2[1]-ints1[1]);
        int count=0,i=0,value=0;
        while (i<boxTypes.length && truckSize > count) {
            value+=boxTypes[i][0]*boxTypes[i][1];
            count+=boxTypes[i++][0];
        }
        if (count>truckSize) {
            value-=(count-truckSize)*boxTypes[i-1][1];
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}},4));
        System.out.println(new Solution().maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10));
        System.out.println(new Solution().maximumUnits(new int[][]{{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}},
        35));
    }
}