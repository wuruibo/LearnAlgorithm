package DynamicProgramming.P120;
import CommonUtils.ArrayUtils;

import java.util.List;

/**
 * 采用递归
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0) {
            return 0;
        }
        int finalRow=triangle.size()-1,minValue=Integer.MAX_VALUE;
        List<Integer> finalList=triangle.get(triangle.size()-1);

        for (int i = 0; i < finalList.size(); i++) {
            int tempMin=recursiveMin(finalRow,i,triangle);
            if (tempMin<minValue) {
                minValue=tempMin;
            }
        }
        return minValue;
    }
    private int recursiveMin(int i,int j,List<List<Integer>> triangle){
        if (i==0) {
            return triangle.get(i).get(j);
        }

        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if (j>0) {
            left=recursiveMin(i-1,j-1,triangle);
        }
        if (j<triangle.get(i-1).size()) {
            right=recursiveMin(i-1,j,triangle);
        }
        return Math.min(left,right)+triangle.get(i).get(j);

    }

    public static void main(String[] args) {
        Integer[][] array={{2,1},{1}};
        List<List<Integer>> list=ArrayUtils.getInstance().getListFromArray(array);
        System.out.println(new Solution().minimumTotal(list));
    }
}