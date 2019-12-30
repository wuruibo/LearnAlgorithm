package DynamicProgramming.P120;

import CommonUtils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
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
 * 状态转移方程如下,根据状态转移方程得到递推的方程式:
 *
 * dp[i][j]= Math.min(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
 *
 * dp[0][j]=triangle.get(0);
 *            
 * @autor yeqiaozhu.
 * @date 2019-12-30
 */
public class UsingDP {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0) {
            return 0;
        }
        //step1 初始化dp数组
        List<List<Integer>> dp= new ArrayList<>();
        dp.add(0,triangle.get(0));

        //step2 循环迭代
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if (j>0) {left=dp.get(i-1).get(j-1);}
                if (j<triangle.get(i-1).size()) {right=dp.get(i-1).get(j);}
                temp.add(j,Math.min(left,right)+triangle.get(i).get(j));
            }
            dp.add(i,temp);
        }
        //step3 找到最小值
        int minValue=Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++) {
            if (dp.get(dp.size()-1).get(i)<minValue) {
                minValue=dp.get(dp.size()-1).get(i);
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        Integer[][] array={{2,1},{1}};
        List<List<Integer>> list= ArrayUtils.getInstance().getListFromArray(array);

        Integer[][] array1={{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> list1= ArrayUtils.getInstance().getListFromArray(array1);
        System.out.println(new UsingDP().minimumTotal(list));
        System.out.println(new UsingDP().minimumTotal(list1));
    }
}
