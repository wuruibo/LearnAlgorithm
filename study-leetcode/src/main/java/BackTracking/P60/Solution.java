package BackTracking.P60;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法的写法
 * 可以通过找规律简化不必要的回溯
 *
 */
class Solution {
    private List<Integer> prepeared= new LinkedList<>();
    //目标回溯位置为0时输出目标字符串
    private int target;
    //目标字符串
    private String targetString;
    public String getPermutation(int n, int k) {
        //将数据构造进入linkedlist
        for (int i = 0; i < n; i++) {
            prepeared.add(i+1);
        }
        target=k;
        //开始backtracking
        backTracking(new StringBuilder());
        return targetString;
    }

    public void backTracking(StringBuilder temp){
        if (prepeared.size()==0) {
            target--;
            if (target==0) {
                targetString=temp.toString();
            }
            return;
        }
        for (int i = 0; i < prepeared.size(); i++) {
            Integer current=prepeared.get(i);
            temp.append(current);
            prepeared.remove(i);
            prepeared.add(i,current);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4,3));
        System.out.println(new Solution().getPermutation(3,3));
        System.out.println(new Solution().getPermutation(4,9));
    }
}