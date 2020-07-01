package Sort.P386;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            backTracking(n,i,result);
        }
        return result;
    }
    public void backTracking(Integer n,Integer temp,List<Integer> result){
        if (temp>n) return;
        result.add(new Integer(temp));
        for (int i = 0; i < 10; i++) {
            temp=(temp*10+i);
            backTracking(n,temp,result);
            temp/=10;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13).toString());
    }
}