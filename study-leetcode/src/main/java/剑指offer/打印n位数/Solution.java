package 剑指offer.打印n位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
class Solution {
    private List<Integer> result= new ArrayList<>();
    private static final Integer threshold=10;
    public int[] printNumbers(int n) {
        dfs("",n);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private void dfs(String temp,int n){
        if (n==0) {
            //收集数据
            int value=Integer.parseInt(temp);
            if (value!=0) {
                result.add(value);
            }
            return;
        }
        for (Integer i = 0; i < threshold; i++) {
            dfs(temp+i,n-1);
        }
    }

    public static void main(String[] args) {
        String value="00";
        System.out.println(Integer.parseInt(value));
        System.out.println(Arrays.stream(new Solution().printNumbers(3)).boxed().collect(Collectors.toList()));
    }
}