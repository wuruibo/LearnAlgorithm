package BackTracking.P254;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * 示例 4:
 *
 * 输入: 32
 * 输出:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */
class Solution {
    /**
     * 所有可能的因子全部放在这里
     */
    private List<Integer> factors= new ArrayList<>();
    /**
     * 存储结果列表
     */
    private List<List<Integer>> resultList=new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        //先找出所有的因子 然后进行排序
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) {
                factors.add(i);
                if (n/i !=i) {
                    factors.add(n/i);
                }
            }
        }
        Collections.sort(factors);
        backTracking(1,n,0,new ArrayList<>());
        return resultList;
    }
    private void backTracking(int result,int n,int start,List<Integer> temp){
        //剪枝
        if (result>n) {
            return;
        }else if (result==n && result!=1){
            resultList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < factors.size(); i++) {
            temp.add(factors.get(i));
            backTracking(result*factors.get(i),n,i,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getFactors(1).toString());
        System.out.println(new Solution().getFactors(37).toString());
        System.out.println(new Solution().getFactors(12).toString());
        System.out.println(new Solution().getFactors(32).toString());
    }
}