package Tree.P606;

import CommonUtils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static final String nullPointer="";
    public String tree2str(TreeNode t) {
        if(t==null){
            return nullPointer;
        }
        String left=tree2str(t.left);
        String right=tree2str(t.right);
        StringBuilder temp=new StringBuilder(String.valueOf(t.val));
        if (left.equals(nullPointer) && right.equals(nullPointer)) {
            return temp.toString();
        }else if(right.equals(nullPointer)){
            temp.append("(").append(left).append(")");
        }else if (left.equals(nullPointer)){
            temp.append("()").append("(").append(right).append(")");
        }else {
            temp.append("(").append(left).append(")").append("(").append(right).append(")");
        }
        return temp.toString();
    }
}