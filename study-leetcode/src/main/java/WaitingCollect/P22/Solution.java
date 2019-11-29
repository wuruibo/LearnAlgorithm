package WaitingCollect.P22;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度O(N^2)
 * 空间复杂度O(N)
 */
class Solution {
    private List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesisMnes("",n,n);
        return this.result;
    }
    public void generateParenthesisMnes(String str,int n,int m){
        if (n==0 && m==0) {
            this.result.add(str);
            return;
        }
        if (n>0) {
            generateParenthesisMnes(str+'(',n-1,m);
        }
        if (m>n) {
            generateParenthesisMnes(str+')',n,m-1);
        }
        return;
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
}