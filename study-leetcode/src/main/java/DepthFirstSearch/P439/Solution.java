package DepthFirstSearch.P439;

/**
 * 输入： "T?T?F:5:3"
 *
 * 输出： "F"
 *
 * 解释： 条件表达式自右向左结合。使用括号的话，相当于：
 *
 *              "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 *           -> "(T ? F : 3)"                 或者       -> "(T ? F : 5)"
 *           -> "F"                                     -> "F"
 *
 */
class Solution {
    public String parseTernary(String expression) {
        return dfs(expression);
    }
    private String dfs(String expression){
        int i=0;
        boolean front=false;
        StringBuilder temp=new StringBuilder();
        while (i<expression.length()){
            char current=expression.charAt(i);
            if (current=='T' && i<expression.length()-1 && expression.charAt(i+1)=='?') {
                front=true;
                i++;
            }else if (current=='?'){
                //开始找断言左边的部分
                int count=1,start=i+1;
                while (count!=0){
                    i++;
                    if (expression.charAt(i)==':') {
                        count--;
                    }
                    if (expression.charAt(i)=='?') {
                        count++;
                    }
                }
                //当前i为匹配的:的位置
                String left=dfs(expression.substring(start,i));
                String right=dfs(expression.substring(i+1));

                return front?left:right;
            }else {
                temp.append(current);
                i++;
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().parseTernary("T?2:3"));
        System.out.println(new Solution().parseTernary("F?TT:4F"));
        System.out.println(new Solution().parseTernary("F?1:T?4:5"));
        System.out.println(new Solution().parseTernary("T?T?F:5:3"));
    }
}